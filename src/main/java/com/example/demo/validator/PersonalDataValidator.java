package com.example.demo.validator;

import com.example.demo.model.PersonalData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PersonalDataValidator {
    private final SwearWordsValidator swearWordsValidator;
    private final SpecialSymbolsValidator specialSymbolsValidator;
    private final LocalDateValidator localDateValidator;
    private final TelephoneValidator telephoneValidator;

    public void isValid(PersonalData personalData) {
        specialSymbolsValidator.isValid(swearWordsValidator.isValid(personalData.getFirstName()));
        specialSymbolsValidator.isValid(swearWordsValidator.isValid(personalData.getLastName()));
        localDateValidator.isValid(personalData.getDateOfBirth());
        telephoneValidator.isValid(personalData.getTelephone().getTelephoneNumber());
    }
}
