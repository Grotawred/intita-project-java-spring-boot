package com.example.demo.model.dto;

import com.example.demo.model.TelephoneCode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TelephoneDTO {
    private Long id;
    private TelephoneCode telephoneCode;
    private int telephoneNumber;
}
