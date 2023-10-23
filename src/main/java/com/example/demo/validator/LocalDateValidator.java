package com.example.demo.validator;

import java.time.LocalDate;

import com.example.demo.util.TimeUtilits;
import com.example.demo.validator.annotation.ValidLocalDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocalDateValidator implements ConstraintValidator<ValidLocalDate, LocalDate> {

    @Override
    public void initialize(ValidLocalDate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext context) {

        if (localDate == null) {
            return true;
        }
        LocalDate currentDate = TimeUtilits.getCurrentDateTime();
        LocalDate minDate = currentDate.minusYears(10);
        LocalDate maxDate = currentDate.minusYears(100);
        return localDate.isBefore(minDate) && localDate.isAfter(maxDate);

    }
}
