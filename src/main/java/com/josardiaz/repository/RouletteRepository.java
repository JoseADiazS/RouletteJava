package com.josardiaz.repository;

import com.josardiaz.domain.Roulette;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class RouletteRepository implements RouletteRedisRepository {

    private static final String KEY = "Roulette";
    private HashOperations hashOperations;
    private final RedisTemplate<String, Roulette> redisTemplate;

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
        return (Roulette) hashOperations.get(KEY,id);
    }

    @Override
    public String save(Roulette roulette) {
        hashOperations.put(KEY,roulette.getId(), roulette);
        return roulette.getId();
    }

    public Roulette updateStatus(Roulette roulette){
        save(roulette);
        return roulette;
    }
}
