package com.example.demo.model.dto;

import com.example.demo.model.Paragraph;
import com.example.demo.model.Post;
import com.example.demo.model.Telephone;
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
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String profileImageUrl;
}
