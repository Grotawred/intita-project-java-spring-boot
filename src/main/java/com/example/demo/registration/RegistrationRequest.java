package com.example.demo.registration;


import com.example.demo.validator.annotation.ValidPassword;

public record RegistrationRequest(
        String email, String login, @ValidPassword String password, String role) {
}
