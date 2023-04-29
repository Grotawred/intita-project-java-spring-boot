package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.registration.RegistrationRequest;
import com.example.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers(){
      return userRepository.findAll();
    }

    public User registerUser(RegistrationRequest request){
        Optional<User> user = this.findByEmail(request.email());
        if(user.isPresent()){
            throw new UserAlreadyExistsException("User with email "+request.email()+" already exists");
        }
        var newUser = new User();
        newUser.setFirstName(request.firstName());
        newUser.setLastName(request.lastName());
        newUser.setEmail(request.email());
        newUser.setPassword(request.password());
        newUser.setRole(request.role());
        return newUser;
    }
    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

}
