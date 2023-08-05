package com.example.demo.validators;

import com.example.demo.exception.LocalDateException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;


public class ValidatorDateOfBirth implements ValidatorLocalDate {
    private LocalDateTime localDateTime;
    public LocalDate execute(LocalDate localDate) {
        if(localDate.isBefore( ChronoLocalDate.from( localDateTime.now().minusYears(10) )) && localDate.isAfter( ChronoLocalDate.from( localDateTime.now().minusYears(100) ) )) {
            return localDate;
        } else {
            throw new LocalDateException("Invalid Date Of Birth");
        }

    }
}
