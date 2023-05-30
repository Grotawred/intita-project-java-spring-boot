package com.example.demo.repository;

import com.example.demo.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    @Query( value = "SELECT * FROM user_info WHERE user_info.user_id = ?1",
    nativeQuery = true)
    UserInfo getUserInfoByUser_id(Long id);
}
