package com.example.demo.controller;

import com.example.demo.service.*;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.service.validatorService.PasswordsValidatorService;
import com.example.demo.service.validatorService.ResetTokenValidatorService;
import com.example.demo.service.validatorService.UserValidatorService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ForgotPasswordController {

    private final UserService userService;
    private final ResetTokenService resetTokenService;
    private final ResetTokenValidatorService resetTokenValidatorService;
    private final UserValidatorService userValidatorService;
    private final PasswordsValidatorService passwordsValidatorService;

    @GetMapping("/forgot_password")
    private String processForgotPasswordPage() {
        return "index";
    }

    @PostMapping("/forgot_password")
    private String processForgotPassword(HttpServletRequest httpServletRequest) {
        String email = httpServletRequest.getParameter("email");
        String token = UUID.randomUUID().toString();

        userValidatorService.executeUserDoesNotExist(email);
        userValidatorService.executeUser(email);

        List<UserDTO> userDTO = userService.findByEmail(email);
        resetTokenService.saveToken(token, userDTO.get(0));
        resetTokenService.createAndSendResetLink(email, token);

        return "index";
    }

    @GetMapping("/reset_password")
    private String processResetPasswordPage(HttpServletRequest request) {
        String token = request.getParameter("token");

        resetTokenValidatorService.resetTokenIsNull(token);
        resetTokenValidatorService.executeResetToken(token);

        return "index";
    }

    @PostMapping("/reset_password")
    private String processResetPassword(HttpServletRequest request) {
        String token = request.getParameter("token");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        resetTokenValidatorService.resetTokenIsNull(token);
        resetTokenValidatorService.executeResetToken(token);
        passwordsValidatorService.executeResetToken(password, confirmPassword);

        return "index";
    }
}
