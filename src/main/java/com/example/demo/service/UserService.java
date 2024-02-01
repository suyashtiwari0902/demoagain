package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRespository userRespository;
    public User registerUser(User user) {
        return userRespository.save(user);
    }
    public Optional<User> findByUsername(String username) {
        return userRespository.findByUsername(username);
    }
}
