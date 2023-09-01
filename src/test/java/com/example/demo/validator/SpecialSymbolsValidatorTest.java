package com.example.demo.validator;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SpecialSymbolsValidatorTest {
    private ConstraintValidatorContext context;

    private SpecialSymbolsValidator validator;

    @BeforeEach
    public void setUp(){
        validator = new SpecialSymbolsValidator();
        context = mock(ConstraintValidatorContext.class);
        ConstraintValidatorContext.ConstraintViolationBuilder builder = mock(ConstraintValidatorContext.ConstraintViolationBuilder.class);
        when(context.buildConstraintViolationWithTemplate(anyString())).thenReturn(builder);
        when(builder.addConstraintViolation()).thenReturn(context);
    }

    @ParameterizedTest
    @CsvSource({
            "Sasha, true",
            "Sasha12, false",
            "Vlad-, false",
            "Bogdan@, false",
            "Masha$, false",
            "Klava+, false",
            "Sas-ha, false",
            "Pa=sha, false",
            "Me>ka, false"
    })

    public void testPasswordValidation(String name, boolean expectedResult) {
        Assertions.assertEquals(expectedResult, validator.isValid(name, context));
    }
}
