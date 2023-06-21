package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "telephones")
@NoArgsConstructor
@AllArgsConstructor
public class Telephone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "telephone_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "telephone_code_id")
    private TelephoneCode telephoneCode;

    @Column(name = "telephone")
    private Long telephoneNumber;
}
