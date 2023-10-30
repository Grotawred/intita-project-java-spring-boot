package com.example.demo.validator;

import java.time.LocalDate;

import com.example.demo.exception.LocalDateException;
import com.example.demo.util.TimeUtilits;

import org.springframework.stereotype.Component;

@Component
public class LocalDateValidator {

    public LocalDate isValid(LocalDate localDate) {

        if (localDate == null) {
            throw new LocalDateException("Wrong Date Of Birth");
        }
        LocalDate currentDate = TimeUtilits.getCurrentDateTime();
        LocalDate minDate = currentDate.minusYears(10);
        LocalDate maxDate = currentDate.minusYears(100);
        if(localDate.isBefore(minDate) && localDate.isAfter(maxDate)) {
            return localDate;
        } else{
            throw new LocalDateException("Wrong Date Of Birth");
        }

    }
}
