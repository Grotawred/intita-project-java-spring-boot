package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "telephones")
@NoArgsConstructor
@AllArgsConstructor
public class Telephone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "telephone_code_id")
    private Long telephoneID;
    @Column(name = "telephone")
    private int telephone;
}
