package com.example.demo.entity.dto;

import com.example.demo.entity.PersonalData;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ParagraphDTO {
    private Long id;
    private Set<PersonalData> personalData;
    private String header;
    private String description;
}
