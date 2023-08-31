package com.example.demo.registration;


import com.example.demo.validator.annotation.ValidPassword;
import lombok.Getter;

@Getter
public final class RegistrationRequest {
    private String email;
    private String login;
    @ValidPassword
    private String password ;
    private String role;

}