package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.*;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="user_id")
  private Long id;
  @ManyToMany
  @JoinTable(
          name = "user_role",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles;
  @OneToOne
  @JoinColumn(name = "personal_data_id", referencedColumnName = "personal_data_id")
  private PersonalData personalData;
  @Column(name = "is_verified")
  private boolean isVerified;
  @Column(name = "registration_date")
  private LocalDateTime registrationDate;
  @Column(name = "verification_date")
  private LocalDateTime verificationDate;
  @Column(name = "login")
  private String login;
  @Column(name = "password")
  private String password;

}
