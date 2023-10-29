package com.example.demo.validator;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class LocalDateValidatorTest {
    private ConstraintValidatorContext context;

    private LocalDateValidator validator;

    @BeforeEach
    public void setUp(){
        validator = new LocalDateValidator();
        context = mock(ConstraintValidatorContext.class);
        ConstraintValidatorContext.ConstraintViolationBuilder builder = mock(ConstraintValidatorContext.ConstraintViolationBuilder.class);
        when(context.buildConstraintViolationWithTemplate(anyString())).thenReturn(builder);
        when(builder.addConstraintViolation()).thenReturn(context);
    }

    @ParameterizedTest
    @CsvSource({
            "1990-03-08, true",
            "1700-03-08, false",
            "1390-03-08, false",
            "1760-03-08, false",
            "1590-03-08, false",
            "2800-03-08, false",
            "1090-03-08, false",
            "1900-03-08, false",
            "1690-03-08, false"
    })

    public void testPasswordValidation(LocalDate localDate, boolean expectedResult) {
        Assertions.assertEquals(expectedResult, validator.isValid(localDate, context));
    }
}
