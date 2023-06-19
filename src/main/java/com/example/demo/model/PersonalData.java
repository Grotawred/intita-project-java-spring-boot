package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "personal_data")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personal_data_id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "telephone_id")
    private Telephone telephone;
    @OneToOne
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToMany
    @JoinTable(
            name = "personal_page",
            joinColumns = @JoinColumn(name = "personal_data_id"),
            inverseJoinColumns = @JoinColumn(name = "paragraph_id"))
    private Set<Paragraph> paragraphs;
    @Column(name = "email")
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "profile_image_url")
    private String profileImageUrl;
}
