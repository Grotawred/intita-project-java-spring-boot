package com.example.demo.model;


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
    private Set<UserData> userData;
    @Column(name = "header")
    private String header;
    @Column(name = "content")
    private String content;
}
