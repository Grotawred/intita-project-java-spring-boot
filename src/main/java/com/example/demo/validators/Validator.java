package com.example.demo.validators;

import com.example.demo.requests.InfoRequest;

public interface Validator {
    boolean execute(InfoRequest infoRequest);

}
