package com.example.demo.validators;

import com.example.demo.request.InfoRequest;
import org.springframework.stereotype.Component;

@Component

public class ValidatorInfoNullable implements Validator {

    @Override
    public boolean execute(InfoRequest infoRequest) {
        return infoRequest == null;
    }
}
