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

  @OneToOne
  @JoinColumn(name = "telephone_code_id")
  private TelephoneCode telephoneId;

  @Column(name = "telephone")
  private int telephone;
}
