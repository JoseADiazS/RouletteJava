package com.josardiaz.modules.roulette.service;

import com.josardiaz.modules.roulette.domain.Roulette;
import com.josardiaz.modules.roulette.repository.RouletteRepository;
import com.josardiaz.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class RouletteService {

    @Autowired
    RouletteRepository repository;

    @Autowired
    UserRepository userRepository;

    public String save(Roulette roulette){
        if(roulette == null){
            roulette = new Roulette();
            roulette.setStatus(Boolean.FALSE);
        }
        roulette.setId(UUID.randomUUID().toString());
        return repository.save(roulette);
    }
}
