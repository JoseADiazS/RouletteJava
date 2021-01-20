package com.josardiaz.controller;

import com.josardiaz.domain.Roulette;
import com.josardiaz.repository.RouletteRepository;
import com.josardiaz.services.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
}
