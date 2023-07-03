package com.example.demo.model.dto;

import com.example.demo.model.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
public class PersonalDataDTO {
    private Long id;
    private Telephone telephone;
    private Post post;
    private Set<Paragraph> paragraphs;
    private Set<Tool> tools;
    private Set<Skill> skills;
    private Set<Task> tasks;
    private Set<Experience> experiences;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String profileImageUrl;
}
