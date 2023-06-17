package com.example.demo.repository;

import com.example.demo.model.UserData;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData, Long> {
    List<UserData> findByEmail(String email);
}
