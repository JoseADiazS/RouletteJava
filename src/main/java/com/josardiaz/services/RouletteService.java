package com.josardiaz.services;

import com.josardiaz.domain.Bet;
import com.josardiaz.domain.Roulette;
import com.josardiaz.domain.User;
import com.josardiaz.repository.RouletteRepository;
import com.josardiaz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.UUID;

@Service
public class RouletteService {

    @Autowired
    RouletteRepository repository;

    UserRepository userRepository;

    public String save(Roulette roulette){
        LinkedList<Bet> bets = new LinkedList<>();
        User user = new User("test","test",12);
        Bet bet = new Bet(UUID.randomUUID().toString(),user.getUserName(),3);
        bets.add(bet);
        if(roulette == null){
            roulette = new Roulette();
            roulette.setStatus(Boolean.FALSE);
        }
        roulette.setId(UUID.randomUUID().toString());
        roulette.setBets(bets);
        return repository.save(roulette);
    }
}
