package com.example.demo.exception.resetTokenExceptions;

public class UserDoesNotExistByEmail extends RuntimeException{
    public UserDoesNotExistByEmail(String message) {
        super(message);
    }
}
