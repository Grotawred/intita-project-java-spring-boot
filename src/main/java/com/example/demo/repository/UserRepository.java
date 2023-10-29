package com.example.demo.repository;

import com.example.demo.entity.PersonalData;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findByLogin(String login);

  Optional<User> findById(Long id);

  List<User> findByPersonalData(PersonalData personalData);
}
