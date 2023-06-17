package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.Set;
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
    @Column(name="user_data_id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User userId;
    @OneToOne
    @JoinColumn(name = "telephone_id")
    private Telephone telephoneId;
    @OneToOne
    @JoinColumn(name = "post_id")
    private Post postId;
    @ManyToMany
    @JoinTable(
            name = "personal_page",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "paragraph_id"))
    private Set<Paragraph> paragraphs;
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
