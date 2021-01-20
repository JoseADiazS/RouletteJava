package com.josardiaz.repository;

import com.josardiaz.domain.User;

import java.util.Map;

public interface UserRedisRepository {
    Map<String, User> findAll();
    User findById(String id);
    void save(User user);
    void delete(User user);
}
