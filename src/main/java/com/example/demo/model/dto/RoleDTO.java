package com.example.demo.model.dto;

import com.example.demo.model.User;
import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleDTO {
    private Long id;
    private Set<User> users;
    private String name;
}
