package com.example.demo.validators;


import com.example.demo.registration.InfoRequest;

import java.time.LocalDate;

public class ValidatorDataNullable implements Validator {

    @Override
    public boolean execute(InfoRequest infoRequest) {
        return infoRequest == null;
    }
}
