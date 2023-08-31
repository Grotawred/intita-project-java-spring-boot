package com.example.demo.request;

import com.example.demo.validator.annotation.ValidSpecialSymbols;
import com.example.demo.validator.annotation.ValidSwearWords;

import java.time.LocalDate;

public record InfoRequest (
        @ValidSwearWords @ValidSpecialSymbols String firstname, @ValidSwearWords @ValidSpecialSymbols String lastname, LocalDate dateOfBirth, String profileImageUrl, String telephoneCode, Long telephoneNumber) {
}