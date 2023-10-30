package com.example.demo.validator;

import com.example.demo.exception.LocalDateException;
import org.springframework.stereotype.Component;

@Component
public class TelephoneValidator {

    public Long isValid(Long telephoneNumber) {
        int telephoneLength = telephoneNumber.toString().length();

        if(telephoneLength <= 12 && telephoneLength > 7) {
            return telephoneNumber;
        } else{
            throw new LocalDateException("Invalid Telephone Number");
        }
    }

}
