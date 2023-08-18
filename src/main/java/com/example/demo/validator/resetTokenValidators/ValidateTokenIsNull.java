package com.example.demo.validator.resetTokenValidators;

import com.example.demo.exception.resetTokenExceptions.TokenIsNull;
import com.example.demo.service.ResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateTokenIsNull implements ResetTokenValidator {

    @Autowired
    private ResetTokenService resetTokenService;

    @Override
    public void execute(String token) {
        if (resetTokenService.validateIfTokenIsNull(token)){
            throw new TokenIsNull("link is not correct");
        }
    }
}
