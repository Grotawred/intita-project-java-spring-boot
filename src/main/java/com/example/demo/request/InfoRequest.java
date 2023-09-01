package com.example.demo.request;

import com.example.demo.validator.annotation.ValidSpecialSymbols;
import com.example.demo.validator.annotation.ValidSwearWords;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record InfoRequest (
        @ValidSwearWords @ValidSpecialSymbols String firstname, @ValidSwearWords @ValidSpecialSymbols String lastname, @Past LocalDate dateOfBirth, String profileImageUrl, String telephoneCode, Long telephoneNumber) {
}