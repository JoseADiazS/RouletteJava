package com.josardiaz.modules.roulette.service;

import com.josardiaz.commons.api.service.GenericService;
import com.josardiaz.modules.roulette.domain.Roulette;
import com.josardiaz.modules.roulette.repository.RouletteRepository;
import com.josardiaz.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class RouletteService extends GenericService<String, Roulette> {

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

    @Override
    public List<Roulette> findAll() {
       return repository.findAll();
    }

    public Roulette opening(String key) throws Exception {
        Roulette roulette = repository.findById(key);
        if(key == null)
            throw new Exception("Null KEY");
        if(roulette == null)
            throw new Exception("Null ROULETTE");
        if(roulette.isStatus())
            throw  new Exception("Roulette is already");
        if(!roulette.getBets().isEmpty())
            roulette.getBets().clear();
        roulette.setStatus(Boolean.TRUE);
        repository.updateStatus(roulette);
        return roulette;
    }
}
