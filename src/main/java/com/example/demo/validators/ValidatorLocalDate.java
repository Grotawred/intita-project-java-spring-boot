package com.example.demo.validators;

import com.uttesh.exude.exception.InvalidDataException;

import java.time.LocalDate;

public interface ValidatorLocalDate {
    LocalDate execute(LocalDate localDate) throws InvalidDataException;
}
