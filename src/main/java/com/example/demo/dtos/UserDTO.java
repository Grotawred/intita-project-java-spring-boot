package com.example.demo.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserDTO {
    private String name;
    private String username;
    private String avatar;
    private String info;
    private String surname;
    private String user_id;
}
