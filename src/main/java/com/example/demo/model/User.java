package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Date;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="user_id")
  private Long id;
  @OneToOne
  @JoinColumn(name = "role_id")
  private Role roleId;
  @OneToOne
  @JoinColumn(name = "user_data_id", referencedColumnName = "user_id")
  private UserData userDataId;
  @Column(name = "is_verified")
  private boolean isVerified;
  @Column(name = "registered_date")
  @CreationTimestamp
  private Date registeredDate;
  @Column(name = "verified_date")
  private Date verifiedDate;
  @Column(name = "login")
  private String login;
  @Column(name = "password")
  private String password;

}
