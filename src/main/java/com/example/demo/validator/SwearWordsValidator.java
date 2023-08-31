package com.example.demo.validator;

import com.example.demo.util.JSONUtilis;
import com.example.demo.validator.annotation.ValidSwearWords;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;

import static com.example.demo.constants.TextConstants.*;

public class SwearWordsValidator implements ConstraintValidator<ValidSwearWords, String> {

    @Override
    public void initialize(ValidSwearWords constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }


    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        boolean isValid = true;

        ArrayList<String> arrSwearWords = JSONUtilis.parse(JSONUtilis.read(JSON_FILE_NAME, JSON_KEY));

        name = name.toLowerCase();

        for(String i : arrSwearWords) {
            if(name.contains(i)) {
                isValid = false;
            }
        }

        return isValid;
} }
