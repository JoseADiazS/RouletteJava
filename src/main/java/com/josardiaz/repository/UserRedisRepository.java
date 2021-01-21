package com.josardiaz.repository;

import com.josardiaz.domain.User;

import java.util.List;
import java.util.Map;

public interface UserRedisRepository {
    Map<String, User> findAll();
    User findById(String id);
    String save(User user);
    void delete(User user);
}
