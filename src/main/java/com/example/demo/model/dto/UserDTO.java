package com.example.demo.model.dto;

import com.example.demo.model.Role;
import com.example.demo.model.UserData;
import jakarta.persistence.*;
import java.sql.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private Long id;
    private Role role;
    private UserData userData;
    private boolean isVerified;
    private Date registeredDate;
    private Date verifiedDate;
    private String login;
    private String password;

}
