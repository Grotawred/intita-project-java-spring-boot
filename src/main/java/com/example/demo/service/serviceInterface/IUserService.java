package com.example.demo.service.serviceInterface;

import com.example.demo.model.User;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.registration.RegistrationRequest;

import java.util.List;

public interface IUserService {
    List<UserDTO> getUsers();

    User registerUser(RegistrationRequest request);

    List<UserDTO> findByEmail(String email);

    void saveUserVerificationToken(UserDTO theUser, String verificationToken);

    String validateToken(String theToken);
}
