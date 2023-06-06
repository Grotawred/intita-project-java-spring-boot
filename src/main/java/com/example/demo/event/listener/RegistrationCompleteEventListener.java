package com.example.demo.event.listener;

import static com.example.demo.constants.Const.*;

import com.example.demo.event.RegistrationCompleteEvent;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.service.UserService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationCompleteEventListener
    implements ApplicationListener<RegistrationCompleteEvent> {

  private final UserService userService;

  private final JavaMailSender mailSender;

  private final UserMapper mapper;

  @Override
  public void onApplicationEvent(RegistrationCompleteEvent event) {
    UserDTO user = mapper.userTOUserDto(event.getUser());
    String verificationToken = UUID.randomUUID().toString();
    userService.saveUserVerificationToken(user, verificationToken);
    String url = event.getApplicationUrl() + MIDDLE_OF_URL_FOR_VERIFY_EMAIL + verificationToken;
    try {
      sendVerificationEmail(url,user);
    } catch (MessagingException | UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
    log.info(LOG_INFO_ABOUT_VERIFY_EMAIL, url);
  }

  public void sendVerificationEmail(String url, UserDTO user)
      throws MessagingException, UnsupportedEncodingException {
    String mailContent =
        "<p> Hi, "
            + user.getFirstName()
            + ", </p>"
            + "<p>Thank you for registering with us,"
            + "Please, follow the link below to complete your registration.</p>"
            + "<a href=\""
            + url
            + "\">Verify your email to activate your account</a>"
            + "<p> Thank you <br> Users Registration Portal Service";

    MimeMessage message = mailSender.createMimeMessage();
    var messageHelper = new MimeMessageHelper(message);
    messageHelper.setFrom(SENDER_EMAIL, SENDER_NAME_EMAIL);
    messageHelper.setTo(user.getEmail());
    messageHelper.setSubject(SUBJECT_FOR_EMAIL_LETTER);
    messageHelper.setText(mailContent, true);
    mailSender.send(message);
  }
}
