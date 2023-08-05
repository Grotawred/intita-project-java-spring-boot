package com.example.demo.validators;

import com.uttesh.exude.exception.InvalidDataException;

import java.time.LocalDate;

public interface ValidatorStringInfo {
    String execute(String info) throws InvalidDataException;
}
