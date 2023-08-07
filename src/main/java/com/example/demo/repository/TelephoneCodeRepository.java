package com.example.demo.repository;

import com.example.demo.entity.TelephoneCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelephoneCodeRepository extends JpaRepository<TelephoneCode, Long> {
    TelephoneCode findByCode(String telephoneCode);

}
