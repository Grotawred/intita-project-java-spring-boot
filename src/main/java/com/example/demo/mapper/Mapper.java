package com.example.demo.mapper;

import com.example.demo.dtos.UserDTO;
import com.example.demo.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public interface Mapper {
    User userDtoToUser(UserDTO userDTO);

    UserDTO userToUserDto(User user);

    List<UserDTO> listOfUserToListOfUserDto(List<User> users);

    List<User> listOfUserDtoToListOfUser(List<UserDTO> userDTOS);
}