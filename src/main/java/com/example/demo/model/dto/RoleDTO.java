package com.example.demo.model.dto;

import com.example.demo.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class RoleDTO {
    private Long id;
    private Set<User> users;
    private String name;
}
