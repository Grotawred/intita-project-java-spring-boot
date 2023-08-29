package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "paragraphs")
@NoArgsConstructor
@AllArgsConstructor
public class Paragraph {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paragraph_id")
    private Long id;

    @ManyToMany(mappedBy = "paragraphs")
    private Set<PersonalData> personalData;

    @Column(name = "header")
    private String header;

    @Column(name = "description")
    private String description;
}
