package com.josardiaz.services;

import com.josardiaz.domain.User;
import com.josardiaz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public String save(User user){
        user.setId(UUID.randomUUID().toString());
        return repository.save(user);
    }
}
