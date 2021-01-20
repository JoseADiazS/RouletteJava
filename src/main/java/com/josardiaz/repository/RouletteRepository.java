package com.josardiaz.repository;

import com.josardiaz.domain.Roulette;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.UUID;

@Repository
public class RouletteRepository implements RouletteRedisRepository {

    private static final String KEY = "Roulette";
    private HashOperations hashOperations;
    private RedisTemplate<String, Roulette> redisTemplate;

    public RouletteRepository(RedisTemplate<String, Roulette> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<String, Roulette> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public Roulette findById(String id) {
        return null;
    }

    @Override
    public String save(Roulette roulette) {
        hashOperations.put(KEY, UUID.randomUUID().toString(), roulette);
        return roulette.getId();
    }

    @Override
    public void delete(Roulette roulette) {

    }
}
