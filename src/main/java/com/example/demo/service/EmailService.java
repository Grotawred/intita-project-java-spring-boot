package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${mail.username}")
    private String from;

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(createHtmlMessageContent(body));

        javaMailSender.send(message);
    }
    private String createHtmlMessageContent(String link) {
        return  "<p>Please, follow the link below to complete your registration.</p>"
                + "<a href=\""
                + link
                + "\">Verify your email to reset your password</a>";
    }
}
