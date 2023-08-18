package com.example.demo.service.validatorService;

import com.example.demo.validator.resetTokenValidators.PasswordsValidator;
import com.example.demo.validator.resetTokenValidators.ValidatePasswordsMatch;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
@Service
public class PasswordsValidatorService {
    private final List<PasswordsValidator> validators = new LinkedList<>();


    public  PasswordsValidatorService(ValidatePasswordsMatch validatePasswordsMatch) {
        validators.add(validatePasswordsMatch);
    }

    public void executeResetToken(String password, String confirmPassword) {
        for (PasswordsValidator validator : validators) {
            validator.execute(password, confirmPassword);
        }
    }
}
