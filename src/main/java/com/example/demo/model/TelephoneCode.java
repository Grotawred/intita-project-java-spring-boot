package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "telephone_codes")
@NoArgsConstructor
@AllArgsConstructor
public class TelephoneCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "telephone_code_id")
    private Long id;
    @Column(name = "code")
    private String code;
}