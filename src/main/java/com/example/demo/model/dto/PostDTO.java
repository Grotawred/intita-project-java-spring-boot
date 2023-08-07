package com.example.demo.model.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PostDTO {
    private Long id;
    private String header;
    private String description;
}
