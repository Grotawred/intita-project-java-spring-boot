package com.example.demo.exception.resetTokenExceptions;

public class TokenIsNotValid extends RuntimeException{
    public TokenIsNotValid(String message) {
        super(message);
    }
}
