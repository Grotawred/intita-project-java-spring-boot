package com.example.demo.validators;

import com.example.demo.registration.InfoRequest;
import com.uttesh.exude.exception.InvalidDataException;

import java.time.LocalDate;

public interface Validator {
    boolean execute(InfoRequest infoRequest);

}
