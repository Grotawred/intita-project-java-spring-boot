package com.example.demo.model.dto;

import com.example.demo.model.TelephoneCode;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountryDTO {
    private Long id;
    private TelephoneCode telephoneCodeId;
    private String country;
}
