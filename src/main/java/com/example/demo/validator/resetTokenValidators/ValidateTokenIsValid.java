package com.example.demo.validator.resetTokenValidators;

import com.example.demo.exception.resetTokenExceptions.TokenIsNotValid;
import com.example.demo.service.ResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateTokenIsValid implements ResetTokenValidator {
    @Autowired
    private ResetTokenService resetTokenService;

    @Override
    public void execute(String token) {
        if (resetTokenService.checkIfTokenIsValid(token)){
            throw new TokenIsNotValid("link is not correct");
        }
    }
}
