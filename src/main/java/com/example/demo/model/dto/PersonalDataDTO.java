package com.example.demo.model.dto;

import com.example.demo.model.Paragraph;
import com.example.demo.model.Post;
import com.example.demo.model.Telephone;
import java.time.LocalDate;
import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonalDataDTO {
    private Long id;
    private Telephone telephone;
    private Post post;
    private Set<Paragraph> paragraphs;
    private String email;
    private String firstName;
    private String last_name;
    private LocalDate dateOfBirth;
    private String profileImageUrl;
}
