package com.example.demo.service.IService;

import com.example.demo.model.UserInfo;
import org.springframework.stereotype.Service;

@Service
public interface IUserInfoService {
    UserInfo getByUserId(Long id);

    void saveUserInfo(UserInfo userInfo);
}
