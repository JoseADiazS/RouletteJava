package com.josardiaz.modules.roulette.repository;

import com.josardiaz.modules.roulette.domain.Roulette;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

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
        hashOperations.put(KEY, roulette.getId(), roulette);
        return roulette.getId();
    }

    @Override
    public void delete(Roulette roulette) {

    }
}
