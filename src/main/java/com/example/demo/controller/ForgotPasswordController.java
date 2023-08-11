package com.example.demo.controller;

import com.example.demo.model.ResetToken;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ResetTokenService;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.service.UserService;
import com.example.demo.validator.annotation.ValidPassword;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.example.demo.constants.TextConstants.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ForgotPasswordController {

    private final UserService userService;
    private final ResetTokenService resetTokenService;


    @PostMapping("/forgot_password")
    private String processForgotPassword(HttpServletRequest httpServletRequest) {
        String email = httpServletRequest.getParameter("email");
        String token = UUID.randomUUID().toString();

        List<UserDTO> userDTO = userService.findByEmail(email);
        if (userDTO != null) {
            resetTokenService.createToken(token, userDTO.get(0));
            String link = "http://localhost/reset_password?token=" + token;
            //send
            return "";

        } else {
            return "";
        }

    }

    @GetMapping("/reset_password")
    private String resetPassword(@RequestParam("token") String token) {
        ResetToken resetToken = resetTokenService.getByToken(token);

        if (resetToken != null) {
            return "";
        }

        return "";
    }

    @PostMapping("/reset_password")
    private String processResetPassword(HttpServletRequest request) {
        String token = request.getParameter("token");
        String password = request.getParameter("password");


        UserDTO userDTO = userService.getByResetToken(token);
        if (userDTO != null) {
            userDTO.setPassword(password);
            userService.save(userDTO);
            return "";
        }

        return "";
    }
}
