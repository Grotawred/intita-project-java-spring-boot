package com.example.demo.validator;

import com.example.demo.validator.annotation.ValidSpecialSymbols;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class SpecialSymbolsValidator implements ConstraintValidator<ValidSpecialSymbols, String> {

    @Override
    public void initialize(ValidSpecialSymbols constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String info, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = true;
        String specialSymbols = "1234567890-=+_)(*&^%$#@!\\|/}{[]?.><,№'\"";
        for(String i : specialSymbols.split("")) {
            if(info.contains(i)) {
                isValid = false;
            }
        }
        return isValid;
    }
}
