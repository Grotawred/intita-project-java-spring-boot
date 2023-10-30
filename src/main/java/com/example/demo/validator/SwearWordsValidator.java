package com.example.demo.validator;

import com.example.demo.exception.SwearWordsException;
import com.example.demo.util.JSONUtilis;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import static com.example.demo.constants.TextConstants.*;

@Component
public class SwearWordsValidator {

    public String isValid(String name) {

        ArrayList<String> arrSwearWords = JSONUtilis.parse(JSONUtilis.read(JSON_FILE_NAME, JSON_KEY));

        name = name.toLowerCase();

        for(String i : arrSwearWords) {
            if(name.contains(i)) {
                throw new SwearWordsException("Bad Words in Data");
            }
        }

        return name;
    }
}
