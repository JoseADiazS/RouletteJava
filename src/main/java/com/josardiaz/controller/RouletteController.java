package com.josardiaz.controller;

import com.josardiaz.domain.Roulette;
import com.josardiaz.repository.RouletteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Map;

@RestController
public class RouletteController implements Serializable {
    public RouletteRepository rouletteRepository;

    public RouletteController(RouletteRepository rouletteRepository) {
        this.rouletteRepository = rouletteRepository;
    }

    @GetMapping("/roulette")
    public Map<String, Roulette> findAll() {
        return rouletteRepository.findAll();
    }


    @PostMapping("/roulette")
    public String createRoulette(@RequestBody Roulette roulette){
        return rouletteRepository.save(roulette);
    }
}
