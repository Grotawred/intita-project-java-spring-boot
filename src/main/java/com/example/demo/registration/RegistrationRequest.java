package com.example.demo.registration;

public record RegistrationRequest(
        String firstName,
        String lastName,
        String password,
        String email,
        String role) {
}
