package com.josardiaz.controller;

import com.josardiaz.config.BetInput;
import com.josardiaz.domain.BetOutput;
import com.josardiaz.domain.Roulette;
import com.josardiaz.repository.RouletteRepository;
import com.josardiaz.services.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/roulette/open/{id}")
    public Roulette openRoulette(@PathVariable String id){
        return rouletteService.openRoulette(id);
    }

    @GetMapping("/roulette/bet/{id}")
    public Roulette bet(@PathVariable(value = "id", required = true) String id,
                      @RequestHeader(value = "userId", required = true) String userId,
                      @RequestBody BetInput betInput) throws Exception {
        return rouletteService.bet(id, userId, betInput);

    }
    @GetMapping("/roulette/close/{id}")
    public Map<String, BetOutput> closeRoulette(@PathVariable(value = "id") String id) throws Exception {
        return rouletteService.closing(id);
    }
}
