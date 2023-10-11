package com.example.demo.validator;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest
public class PasswordValidatorTest {

  private PasswordConstraintValidator validator;


  private ConstraintValidatorContext context;

  @BeforeEach
  public void setUp(){
    validator = new PasswordConstraintValidator();
    context = mock(ConstraintValidatorContext.class);
    ConstraintValidatorContext.ConstraintViolationBuilder builder = mock(ConstraintValidatorContext.ConstraintViolationBuilder.class);
    when(context.buildConstraintViolationWithTemplate(Mockito.anyString())).thenReturn(builder);
    when(builder.addConstraintViolation()).thenReturn(context);
  }

  @ParameterizedTest
  @CsvSource({
          "TestPassword1@, true",
          "Test, false",
          "testpassword1@, false",
          "Testpassword@, false",
          "Testpassword1, false",
          "1234567890@A, false",
          "Abcdefg1@, false",
          "Qwerty1@, false",
          "Test Password1@, false"
  })
  public void testPasswordValidation(String password, boolean expectedResult) {
    assertEquals(expectedResult, validator.isValid(password, context));
  }
}