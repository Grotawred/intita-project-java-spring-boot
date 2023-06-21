package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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
