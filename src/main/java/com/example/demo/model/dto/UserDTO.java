package com.example.demo.model.dto;

import com.example.demo.model.PersonalData;
import com.example.demo.model.Role;
import java.time.ZonedDateTime;
import java.util.Set;
import lombok.Builder;
import lombok.Data;

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
