package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Date;
import lombok.*;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "role_id")
  @OneToOne()
  private Long roleID;
  @Column(name = "user_data_id")
  private Long userDataID;
  @Column(name = "is_verified")
  private boolean isVerified;
  @Column(name = "registered_date")
  private Date registeredDate;
  @Column(name = "verified_date")
  private String password;
  @Column(name = "login")
  private String login;

}
