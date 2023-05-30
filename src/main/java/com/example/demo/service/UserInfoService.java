package com.example.demo.service;

import com.example.demo.model.UserInfo;
import com.example.demo.repository.UserInfoRepository;
import com.example.demo.service.IService.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService implements IUserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo getByUserId(Long id) {
        return userInfoRepository.getUserInfoByUser_id(id);
    }

    @Override
    public void saveUserInfo(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }
}
