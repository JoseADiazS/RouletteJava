package com.josardiaz.controller;

import com.josardiaz.domain.User;
import com.josardiaz.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Map;

@RestController
public class UserController implements Serializable {
    public UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public Map<String, User> findAll() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    public void createUser(@RequestBody User user){
        userRepository.save(user);
    }
}
