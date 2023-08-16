package com.example.demo.controller;

import com.example.demo.service.ResetTokenService;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.service.UserService;
import com.example.demo.validator.PasswordConstraintValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidatorContext;
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
    private final PasswordConstraintValidator passwordConstraintValidator;

    @GetMapping("/forgot_password")
    private String processForgotPasswordPage() {
        return "html_page";
    }

    @PostMapping("/forgot_password")
    private String processForgotPassword(HttpServletRequest httpServletRequest) {
        String email = httpServletRequest.getParameter("email");
        String token = UUID.randomUUID().toString();
        List<UserDTO> userDTO = userService.findByEmail(email);

        if (userService.checkIfUserExistByEmail(email)) {
            resetTokenService.saveToken(token, userDTO.get(0));
            resetTokenService.createAndSendResetLink(email, token);
            return "html_page";
        }
        return "html_page_error";
    }

    @GetMapping("/reset_password")
    private String processResetPasswordPage(HttpServletRequest request) {
        String token = request.getParameter("token");

        if (userService.checkIfUserExistByToken(token)
                && resetTokenService.validateToken(token)) {
            return "html_page";
        }
        return "html_page_error";
    }

    @PostMapping("/reset_password")
    private String processResetPassword(HttpServletRequest request) {
        String token = request.getParameter("token");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");


        if (userService.checkIfUserExistByToken(token) && resetTokenService.validateToken(token)) {
            if (resetTokenService.confirmPassword(password, confirmPassword)) {
                UserDTO userDTO = userService.getByResetToken(token);
                userDTO.setPassword(password);
                userService.save(userDTO);
                resetTokenService.deleteToken(token);

            }
            return "html_page";
        }
        return "html_page_error";
    }
}
