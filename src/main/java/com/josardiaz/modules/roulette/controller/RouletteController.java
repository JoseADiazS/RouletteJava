package com.josardiaz.modules.roulette.controller;

import com.josardiaz.modules.roulette.domain.Roulette;
import com.josardiaz.modules.roulette.repository.RouletteRepository;
import com.josardiaz.modules.roulette.service.RouletteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Map;

@RestController
public class RouletteController implements Serializable {
    public RouletteRepository rouletteRepository;
    RouletteService rouletteService;

    public RouletteController(RouletteRepository rouletteRepository) {
        this.rouletteRepository = rouletteRepository;
    }

    @GetMapping("/roulette")
    public Map<String, Roulette> findAll() {
        return rouletteRepository.findAll();
    }


    @PostMapping("/roulette")
    public String createRoulette(@RequestBody Roulette roulette){
        var roulette1 = rouletteService.save(roulette);
        return roulette1;
    }
}
