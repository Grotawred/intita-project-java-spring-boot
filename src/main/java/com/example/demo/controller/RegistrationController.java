package com.example.demo.controller;

import static com.example.demo.constants.Const.*;

import com.example.demo.event.RegistrationCompleteEvent;
import com.example.demo.model.User;
import com.example.demo.registration.RegistrationRequest;
import com.example.demo.registration.token.VerificationToken;
import com.example.demo.registration.token.VerificationTokenRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.Utilis;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {

  private final UserService userService;
  private final ApplicationEventPublisher publisher;
  private final VerificationTokenRepository tokenRepository;

  @PostMapping
  public String registerUser(
          @RequestBody RegistrationRequest registrationRequest, final HttpServletRequest request) {
    User user = userService.registerUser(registrationRequest);
    publisher.publishEvent(new RegistrationCompleteEvent(user, Utilis.applicationUrl(request)));
    return TEXT_FOR_COMPLETE_EMAIL_VERIFICATION;
  }

  @GetMapping("/verifyEmail")
  public String verifyEmail(@RequestParam("token") String token) {
    VerificationToken theToken = tokenRepository.findByToken(token);
    if (theToken.getUser().isEnabled()) {
      return TEXT_FOR_SHOW_INFO_ABOUT_ALREADY_VERIFY_EMAIL;
    }
    String verificationResult = userService.validateToken(token);
    if (verificationResult.equalsIgnoreCase("valid")) {
      return TEXT_FOR_SUCCESS_VERIFIED_EMAIL;
    }
    return TEXT_ABOUT_INVALID_VERIFICATION_TOKEN;
  }
}