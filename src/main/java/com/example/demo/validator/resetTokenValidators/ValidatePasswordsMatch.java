package com.example.demo.validator.resetTokenValidators;

import com.example.demo.exception.resetTokenExceptions.PasswordsDoNotMatch;
import com.example.demo.service.ResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatePasswordsMatch implements PasswordsValidator {
    @Autowired
    private ResetTokenService resetTokenService;
    @Override
    public void execute(String password, String confirmPassword) {
        if (!resetTokenService.confirmPassword(password, confirmPassword)){
            throw new PasswordsDoNotMatch("passwords do not match");
        }
    }
}
