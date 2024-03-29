package com.example.demo.entity;

import java.util.Set;

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
