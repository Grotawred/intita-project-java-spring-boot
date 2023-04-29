package com.example.demo.config.registration;

public record RegistrationRequest(
        String firstName,
        String lastName,
        String password,
        String email,
        String role) {
}
