package com.example.demo.validators;

import com.example.demo.registration.InfoRequest;

public class ValidatorInfoNullable implements Validator {

    @Override
    public boolean execute(InfoRequest infoRequest) {
        return infoRequest == null;
    }
}
