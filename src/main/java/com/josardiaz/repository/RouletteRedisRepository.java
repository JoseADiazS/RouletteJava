package com.josardiaz.repository;

import com.josardiaz.domain.Roulette;

import java.util.Map;

public interface RouletteRedisRepository {
    Map<String, Roulette> findAll();
    Roulette findById(String id);
    void save(Roulette roulette);
    void delete(Roulette roulette);
}
