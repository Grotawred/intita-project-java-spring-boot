package com.example.demo.validator.annotation;

import com.example.demo.validator.LocalDateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LocalDateValidator.class)
@Documented
public @interface ValidLocalDate {
    String message() default "Некоректна дата і час";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}