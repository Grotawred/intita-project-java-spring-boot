package com.example.demo.repository;

import com.example.demo.model.PersonalData;
import com.example.demo.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findByLogin(String login);

  List<User> findByPersonalData(PersonalData personalData);
}
