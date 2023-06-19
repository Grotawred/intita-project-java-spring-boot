package com.example.demo.repository;

import com.example.demo.model.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<PersonalData, Long> {
  PersonalData findByEmail(String email);
}
