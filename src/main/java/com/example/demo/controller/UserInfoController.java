package com.example.demo.controller;

import com.example.demo.model.UserInfo;
import com.example.demo.service.UserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;


    @Operation()
    @GetMapping("/user/{id}/info")
    public ResponseEntity<UserInfo> getUserInfo(@PathVariable(name = "id") Long id){

        return ResponseEntity.ok(userInfoService.getByUserId(id));
    }

    @PostMapping("/user/info")
    public ResponseEntity<UserInfo> saveUserInfo(UserInfo userInfo){
        userInfoService.saveUserInfo(userInfo);
        return ResponseEntity.ok(userInfoService.getByUserId(userInfo.getUser_id()));
    }

    @GetMapping("/user/info/edit/{id}")
    public ResponseEntity<UserInfo> editUserInfo(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(userInfoService.getByUserId(id));
    }
    @PostMapping("/user/info/{id}")
    public ResponseEntity<UserInfo> updateUserInfo(@PathVariable Long id, UserInfo userInfo){
        UserInfo existingUserInfo = userInfoService.getByUserId(id);
        existingUserInfo.setName(userInfo.getName());
        existingUserInfo.setSurname(userInfo.getSurname());
        existingUserInfo.setUrl_github(userInfo.getUrl_github());
        existingUserInfo.setUrl_instagram(userInfo.getUrl_instagram());
        existingUserInfo.setUsername(userInfo.getUsername());

        userInfoService.saveUserInfo(existingUserInfo);
        return ResponseEntity.ok(userInfoService.getByUserId(existingUserInfo.getUser_id()));
    }

}
