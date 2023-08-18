package com.example.demo.exception.resetTokenExceptions;

public class PasswordsDoNotMatch extends RuntimeException{
    public PasswordsDoNotMatch(String message) {
        super(message);
    }
}
