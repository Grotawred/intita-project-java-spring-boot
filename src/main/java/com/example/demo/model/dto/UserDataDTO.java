package com.example.demo.model.dto;

import com.example.demo.model.Paragraph;
import com.example.demo.model.Post;
import com.example.demo.model.Telephone;
import com.example.demo.model.User;
import jakarta.persistence.*;
import java.sql.Date;
import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDataDTO {
    private Long id;
    private User userId;
    private Telephone telephoneId;
    private Post postId;
    private Set<Paragraph> paragraphs;
    private String email;
    private String firstName;
    private String last_name;
    private Date dateOfBirth;
    private String profileImageUrl;
}
