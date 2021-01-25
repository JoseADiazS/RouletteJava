package com.josardiaz.services;

import com.josardiaz.domain.User;
import com.josardiaz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public String save(User user){
        user.setId(UUID.randomUUID().toString());
        repository.save(user);
        return user.getId();
    }
}
