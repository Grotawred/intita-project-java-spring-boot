package com.example.demo.entity.dto;

import com.example.demo.entity.TelephoneCode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TelephoneDTO {
    private Long id;
    private TelephoneCode telephoneCode;
    private Long telephoneNumber;
}
