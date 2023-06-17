package com.example.demo.service;

import com.example.demo.dtos.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.mapper.Mapper;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.hibernate.sql.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private static UserRepository userRepository;
    private static Mapper mapper;
    public User saveUser(User user) {

        var newUser =
                UserDTO.builder()
                        .name(user.getName())
                        .surname(user.getSurname())
                        .info(user.getInfo())
                        .username(user.getUsername())
                        .avatar(user.getAvatar())
                        .build();
        return userRepository.save(mapper.userDtoToUser(newUser));

    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).get();
        return mapper.userToUserDto(user);
    }

    public User updateUser(User user) {
        var newUser =
                UserDTO.builder()
                        .name(user.getName())
                        .surname(user.getSurname())
                        .info(user.getInfo())
                        .username(user.getUsername())
                        .avatar(user.getAvatar())
                        .build();
        return userRepository.save(mapper.userDtoToUser(newUser));
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}

