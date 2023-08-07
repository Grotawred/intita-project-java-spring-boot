package com.example.demo.validators;


import com.example.demo.requests.InfoRequest;

public class ValidatorDataNullable implements Validator {

    @Override
    public boolean execute(InfoRequest infoRequest) {
        return infoRequest == null;
    }
}
