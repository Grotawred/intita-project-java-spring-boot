package com.example.demo.service.validatorService;


import com.example.demo.validator.resetTokenValidators.ResetTokenValidator;
import com.example.demo.validator.resetTokenValidators.ValidateTokenIsNull;
import com.example.demo.validator.resetTokenValidators.ValidateTokenIsValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ResetTokenValidatorService {
    private final List<ResetTokenValidator> validators = new LinkedList<>();
    @Autowired
    private ValidateTokenIsNull validateTokenIsNull;

    public  ResetTokenValidatorService(ValidateTokenIsNull validateTokenIsNull,
                                       ValidateTokenIsValid validateTokenIsValid) {
        validators.add(validateTokenIsValid);
        validators.add(validateTokenIsNull);
    }

    public void executeResetToken(String token) {
        for (ResetTokenValidator validator : validators) {
            validator.execute(token);
        }
    }
        public void resetTokenIsNull(String token) {
            validateTokenIsNull.execute(token);
    }
}
