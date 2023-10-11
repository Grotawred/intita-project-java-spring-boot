package com.example.demo.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TelephoneCodeDTO {
    private Long id;
    private String code;
}
