package com.example.demo.controller;

import com.example.demo.services.EmailService;
import com.example.demo.models.User;
import com.example.demo.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@org.springframework.stereotype.Controller

public class Controller {
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;

    @GetMapping("/forgot_password")
    private String forgotPassword() {
        return "forgot-password";
    }

    @PostMapping("/forgot_password")
    private String processForgotPassword(HttpServletRequest httpServletRequest) {
        String email = httpServletRequest.getParameter("email");
        String token = UUID.randomUUID().toString();

        User user = userService.getByEmail(email);
        if (user != null) {
            userService.setToken(email, token);
            String link = "http://localhost/reset_password?token=" + token;
            emailService.send(email, link);
            return "link";

        } else {
            return "redirect:/forgot_password?error";
        }

    }

    @GetMapping("/reset_password")
    private String resetPassword(@RequestParam("token") String token, Model model) {
        User user = userService.getByToken(token);
        model.addAttribute("token", token);

        if (user != null) {
            return "reset-password";
        }

        return "redirect:/reset_password?error";
    }

    @PostMapping("/reset_password")
    private String processResetPassword(HttpServletRequest request) {
        String token = request.getParameter("token");
        String password = request.getParameter("password");

        User user = userService.getByToken(token);
        if (user != null) {
            userService.verified(user.getEmail(), password);
            return "successful-result";
        }

        return "redirect:/reset_password?error";
    }
}
