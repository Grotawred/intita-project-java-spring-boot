package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user_data")
@NoArgsConstructor
@AllArgsConstructor
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "telephone_id")
    private Long telephoneID;
    @Column(name = "post_id")
    private Long postID;
    @Column(name = "personal_page_id")
    private Long personalPageID;
    @Column(name = "email")
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "profile_image_url")
    private String profileImageUrl;
}
