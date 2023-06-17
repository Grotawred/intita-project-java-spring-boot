package com.example.demo.model.dto;

import com.example.demo.model.TelephoneCode;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TelephoneDTO {
    private Long id;
    private TelephoneCode telephoneId;
    private int telephone;
}
