package com.example.demo.validator.annotation;

import com.example.demo.validator.SpecialSymbolsValidator;
import com.example.demo.validator.SwearWordsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;


@Documented
@Constraint(validatedBy = SpecialSymbolsValidator.class)
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidSpecialSymbols {
    String message() default "Special Symbols in Data";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
