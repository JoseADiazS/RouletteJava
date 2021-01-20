package com.josardiaz.modules.roulette.repository;

import com.josardiaz.modules.roulette.domain.Roulette;

import java.util.List;

public interface RouletteRedisRepository {
    List findAll();
    Roulette findById(String id);
    String save(Roulette roulette);
    void delete(Roulette roulette);
}
