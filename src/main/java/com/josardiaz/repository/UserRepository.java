package com.josardiaz.repository;

import com.josardiaz.domain.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class UserRepository implements UserRedisRepository{

    private static final String KEY = "User";
    private HashOperations hashOperations;
    private final RedisTemplate<String,User> redisTemplate2;

    public UserRepository(RedisTemplate<String, User> redisTemplate2) {
        this.redisTemplate2 = redisTemplate2;
    }

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate2.opsForHash();
    }

    @Override
    public Map<String,User> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public User findById(String id) {
        return (User) hashOperations.get(KEY,id);
    }

    @Override
    public String save(User user) {
        hashOperations.put(KEY, user.getId(), user);
        return user.getId();
    }

    @Override
    public void delete(User delete) {
        hashOperations.delete(KEY,delete.getId());
    }
}
