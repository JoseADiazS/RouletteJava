package com.josardiaz.repository;

import com.josardiaz.domain.Roulette;

import java.util.Map;

public interface RouletteRedisRepository {
    Map<String, Roulette> findAll();
    Roulette findById(String id);
    String save(Roulette roulette);
    Roulette updateStatus(Roulette roulette);
}
