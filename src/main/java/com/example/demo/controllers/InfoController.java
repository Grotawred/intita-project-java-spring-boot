package com.example.demo.controllers;

import com.example.demo.dtos.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.mapper.Mapper;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController("/user")
public class InfoController {

    UserService userService;
    Mapper mapper;

    @Operation(summary = "go to edit info page")
    @GetMapping("details")
    public UserDTO editUser(@PathVariable Long id){
//        model.addAttribute("user", userService.getUserById(id));
        return userService.getUserById(id);
//        return "editInfo";
    }

    @Operation(summary = "Update user info")
    @PostMapping("details")
    public @ResponseBody UserDTO updateInfo(@PathVariable Long id, User user){

        UserDTO existingUser = userService.getUserById(id);

//        existingUser.setInfo(user.getInfo());
//        existingUser.setName(user.getName());
//        existingUser.setSurname(user.getSurname());
//        existingUser.setUsername(user.getUsername());
//        existingUser.setAvatar(user.getAvatar());
        //зробити через білдер

        var newUser =
                UserDTO.builder()
                        .name(user.getName())
                        .surname(user.getSurname())
                        .info(user.getInfo())
                        .username(user.getUsername())
                        .avatar(user.getAvatar())
                        .build();
        return newUser;

//        return userService.updateUser(mapper.userDtoToUser(existingUser));

//        return "redirect:/userProfile";

    }

}
