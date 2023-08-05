package com.example.demo.validators;

import com.uttesh.exude.exception.InvalidDataException;

public class ValidateContainSpecialSymbols implements ValidatorStringInfo {
    @Override
    public String execute(String info) throws InvalidDataException {
        String specialSymbols = "1234567890-=+_)(*&^%$#@!\\|/}{[]?.><,№'\"";
        for(String i : specialSymbols.split("")) {
            if(info.contains(i)) {
                throw new InvalidDataException("Special Symbols in Data");
            } else {
                return info;
            }
        }
        return info;
    }
}
