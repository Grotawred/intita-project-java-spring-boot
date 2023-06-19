package com.example.demo.registration;


public record RegistrationRequest(
        String email, String login, String password, String role) {}
