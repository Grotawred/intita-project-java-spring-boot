package com.example.demo.validator;

import com.example.demo.exception.SwearWordsException;
import org.springframework.stereotype.Component;

@Component
public class SpecialSymbolsValidator{

    public String isValid(String info) {

        String specialSymbols = "1234567890-=+_)(*&^%$#@!\\|/}{[]?.><,№'\"";
        for(String i : specialSymbols.split("")) {
            if(info.contains(i)) {
                throw new SwearWordsException("Special symbols are not allowed in Data");
            }
        }

        return info;
    }
}
