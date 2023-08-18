package com.example.demo.validator.resetTokenValidators;

import com.example.demo.exception.resetTokenExceptions.UserDoesNotExistByEmail;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateUserDoesNotExistByEmail implements UserValidator {
    @Autowired
    private UserService userService;

    @Override
    public void execute(String email) {
        if (userService.checkIfUserExistByEmail(email)){
            throw new UserDoesNotExistByEmail("this email is not used");
        }
    }
}
