package com.example.demo.services;


import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User getByToken(String token) {
        return userRepository.findByToken(token);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void setToken(String email, String token) {
        User user = getByEmail(email);
        user.setToken(token);
        save(user);
    }

    public void verified(String email, String password) {
        User user = getByEmail(email);
        user.setPassword(password);
        user.setToken(null);
        save(user);
    }
}
