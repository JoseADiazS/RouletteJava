package com.josardiaz.modules.user.repository;

import com.josardiaz.modules.user.domain.User;

import java.util.Map;

public interface UserRedisRepository {
    Map<String, User> findAll();
    User findById(String id);
    void save(User user);
    void delete(User user);
}
