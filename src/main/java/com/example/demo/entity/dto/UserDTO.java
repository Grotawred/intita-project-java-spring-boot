package com.example.demo.entity.dto;

import com.example.demo.entity.PersonalData;
import com.example.demo.entity.Role;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Set;

@Data
@Builder
public class UserDTO {
    private Long id;
    private Set<Role> roles;
    private PersonalData personalData;
    private boolean isVerified;
    private ZonedDateTime registrationDate;
    private ZonedDateTime verificationDate;
    private String login;
    private String password;

}
