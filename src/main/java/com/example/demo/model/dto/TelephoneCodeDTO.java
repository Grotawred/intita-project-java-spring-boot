package com.example.demo.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TelephoneCodeDTO {
    private Long id;
    private int code;
}
