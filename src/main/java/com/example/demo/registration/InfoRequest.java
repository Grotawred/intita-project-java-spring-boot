package com.example.demo.registration;

import java.time.LocalDate;

public record InfoRequest (
        String firstname, String lastname, LocalDate dateOfBirth, String profileImageUrl) { //TODO telephone
}