package com.example.demo.service.validatorService;

import com.example.demo.validator.resetTokenValidators.UserValidator;
import com.example.demo.validator.resetTokenValidators.ValidateUserDoesNotExistByEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserValidatorService {
    private final List<UserValidator> validators = new LinkedList<>();
    @Autowired
    private ValidateUserDoesNotExistByEmail validateUserDoesNotExistByEmail;

    public  UserValidatorService (ValidateUserDoesNotExistByEmail validateUserDoesNotExistByEmail) {
        validators.add(validateUserDoesNotExistByEmail);
    }

    public void executeUser(String email) {
        for (UserValidator validator: validators){
            validator.execute(email);
        }
    }
    public void executeUserDoesNotExist(String email) {
        validateUserDoesNotExistByEmail.execute(email);
    }
}
