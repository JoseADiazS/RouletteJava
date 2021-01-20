package com.josardiaz.modules.roulette.repository;

import com.josardiaz.modules.roulette.domain.Roulette;

import java.util.Map;

public interface RouletteRedisRepository {
    Map<String, Roulette> findAll();
    Roulette findById(String id);
    String save(Roulette roulette);
    void delete(Roulette roulette);
}
