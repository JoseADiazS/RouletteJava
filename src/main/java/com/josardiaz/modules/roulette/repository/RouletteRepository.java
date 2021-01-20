package com.josardiaz.modules.roulette.repository;

import com.josardiaz.modules.roulette.domain.Roulette;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RouletteRepository implements RouletteRedisRepository {

    private static final String KEY = "Roulette";
    private HashOperations hashOperations;
    private RedisTemplate<String, Roulette> redisTemplate;

    public RouletteRepository(RedisTemplate redisTemplate) {

        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public List findAll() {
        return hashOperations.values(KEY);
    }

    @Override
    public Roulette findById(String id) {
        return null;
    }

    @Override
    public String save(Roulette roulette) {
        hashOperations.put(KEY, roulette.getId(), roulette);
        return roulette.getId();
    }

    @Override
    public void delete(Roulette roulette) {

    }

    public Roulette updateStatus(Roulette entity){
        save(entity);
        return entity;
    }
}
