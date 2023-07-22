package com.example.demo.controller;

import com.example.demo.event.RegistrationCompleteEvent;
import com.example.demo.model.User;
import com.example.demo.registration.RegistrationRequest;
import com.example.demo.registration.token.VerificationToken;
import com.example.demo.registration.token.VerificationTokenRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.URLUtilis;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.constants.TextConstants.*;
@RestController
@RequiredArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;
    private final ApplicationEventPublisher publisher;
    private final VerificationTokenRepository tokenRepository;

    @PostMapping
    public String registerUser(
            @RequestBody RegistrationRequest registrationRequest, final HttpServletRequest request) {
        User user = userService.registerUser(registrationRequest);
        String email = registrationRequest.email();
        publisher.publishEvent(new RegistrationCompleteEvent(user, URLUtilis.applicationUrl(request), email));
        return EMAIL_VERIFICATION_COMPLETE_MESSAGE;
    }

    @GetMapping("/email/verification")
    public String verifyEmail(@RequestParam("token") String token) {
        VerificationToken verificationToken = tokenRepository.findByToken(token);
        if (verificationToken.getUser().isVerified()) {
            return ALREADY_VERIFIED_EMAIL_MESSAGE;
        }
        String verificationResult = userService.validateToken(token);
        if (verificationResult.equalsIgnoreCase("valid")) {
            return EMAIL_VERIFIED_SUCCESS_MESSAGE;
        }
        return INVALID_VERIFICATION_TOKEN_LOG_MESSAGE;
    }
}
