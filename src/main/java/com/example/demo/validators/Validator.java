package com.example.demo.validators;

import com.example.demo.request.InfoRequest;

public interface Validator {
    boolean execute(InfoRequest infoRequest);

}
