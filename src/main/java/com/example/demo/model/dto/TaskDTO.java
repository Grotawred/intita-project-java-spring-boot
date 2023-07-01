package com.example.demo.model.dto;

import com.example.demo.model.PersonalData;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class TaskDTO {
    private Long id;
    private Set<PersonalData> personalData;
    private String name;
    private String description;
}
