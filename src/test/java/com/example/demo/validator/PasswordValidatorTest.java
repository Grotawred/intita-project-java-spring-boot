package com.example.demo.validator;

import com.example.demo.validator.PasswordConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;


@SpringBootTest
public class PasswordValidatorTest {

  private PasswordConstraintValidator validator;


  private ConstraintValidatorContext context;

  @BeforeEach
  public void setUp(){
    validator = new PasswordConstraintValidator();
    context = Mockito.mock(ConstraintValidatorContext.class);
    ConstraintValidatorContext.ConstraintViolationBuilder builder = Mockito.mock(ConstraintValidatorContext.ConstraintViolationBuilder.class);
    Mockito.when(context.buildConstraintViolationWithTemplate(Mockito.anyString())).thenReturn(builder);
    Mockito.when(builder.addConstraintViolation()).thenReturn(context);
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