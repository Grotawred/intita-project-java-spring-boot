package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
          name = "user_role_relations",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles;
  @OneToOne
  @JoinColumn(name = "personal_data_id", referencedColumnName = "personal_data_id")
  private PersonalData personalData;
  @Column(name = "is_verified")
  private boolean isVerified;
  @Column(name = "registration_date_time")
  private LocalDateTime registrationDateTime;
  @Column(name = "verification_date_time")
  private LocalDateTime verificationDateTime;
  @Column(name = "login")
  private String login;
  @Column(name = "password")
  private String password;

}
