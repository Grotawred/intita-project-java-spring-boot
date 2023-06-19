package com.example.demo.repository;

import com.example.demo.model.Role;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Set<Role> findRoleByName(String name);
}
