package com.josardiaz.controller;

import com.josardiaz.domain.Roulette;
import com.josardiaz.repository.RouletteRepository;
import com.josardiaz.services.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Map;

@RestController
public class RouletteController implements Serializable {
    @Autowired
    RouletteRepository rouletteRepository;
    @Autowired
    RouletteService rouletteService;

    public RouletteController(RouletteRepository rouletteRepository) {
        this.rouletteRepository = rouletteRepository;
    }

    @GetMapping("/roulette")
    public Map<String, Roulette> findAll() {
        return rouletteRepository.findAll();
    }


    @PostMapping("/roulette")
    public String createRoulette(Roulette roulette){
        return rouletteService.save(roulette);
    }
}
