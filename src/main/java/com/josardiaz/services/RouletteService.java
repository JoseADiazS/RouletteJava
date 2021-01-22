package com.josardiaz.services;

import com.josardiaz.config.BetInput;
import com.josardiaz.config.RandomWinnerGenerator;
import com.josardiaz.domain.Bet;
import com.josardiaz.domain.BetOutput;
import com.josardiaz.domain.Roulette;
import com.josardiaz.domain.User;
import com.josardiaz.enums.ColorsEnum;
import com.josardiaz.enums.TypeEnum;
import com.josardiaz.repository.RouletteRepository;
import com.josardiaz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class RouletteService {

    @Autowired
    RouletteRepository repository;
    @Autowired
    UserRepository userRepository;

    public static final String RED = "red";
    public static final String BLACK = "black";


    public String save(Roulette roulette) {
//        LinkedList<Bet> bets = new LinkedList<>();
//        User user = new User("test","test",12);
//        Bet bet = new Bet(UUID.randomUUID().toString(),user.getUserName(),3);
//        bets.add(bet);
        if (roulette == null) {
            roulette = new Roulette();
            roulette.setStatus(Boolean.FALSE);
        }
        roulette.setId(UUID.randomUUID().toString());
//        roulette.setBets(bets);
        return repository.save(roulette);
    }

    public Roulette openRoulette(String id) {
        Roulette roulette = repository.findById(id);
        roulette.setStatus(Boolean.TRUE);
        repository.updateStatus(roulette);
        return roulette;
    }

    public Roulette bet(String id, String userId, BetInput betInput) throws Exception {
        User user = userRepository.findById(userId);
        TypeEnum type = this.isValid(betInput);
        Roulette roulette = repository.findById(id);
        if (user == null) {
            throw new Exception("User not found");
        } else if (roulette == null) {
            throw new Exception("Roulette not found");
        } else if (roulette.getBets().equals(Boolean.FALSE)) {
            throw new Exception("Roulette Closed");
        } else if (user.getBalance() < betInput.getMoney()) {
            throw new Exception("Not enough money for bet");
        } else if (!(betInput.getMoney() >= 1 && betInput.getMoney() <= 1000)) {
            throw new Exception("Bet is out of range");
        } else if (!validateValueByType(betInput.getNumber(), betInput.getColor(), type)) {
            throw new Exception("Invalid input values");
        } else if (id == null) {
            throw new Exception("Empty Key");
        } else {
            validateScoreArray(roulette, buildRouletteBet(betInput.getNumber(), betInput.getColor(), betInput.getMoney(),
                    type, user));
            repository.save(roulette);
        }
        return roulette;
    }

    public TypeEnum isValid(BetInput betInput) throws Exception {
        if (StringUtils.isEmpty(String.valueOf(betInput.getNumber())) && StringUtils.isEmpty(betInput.getColor())) {
            throw new Exception("Invalid Number o Color");
        } else if (betInput.getNumber() > 0 && !StringUtils.isEmpty(betInput.getColor())) {
            throw new Exception("Choose just One Color or One Number");
        } else if (!StringUtils.isEmpty(betInput.getColor())) {
            return TypeEnum.COLOR;
        } else if (betInput.getNumber() > 0) {
            return TypeEnum.NUMBER;
        } else {
            throw new Exception("Invalid Input");
        }
    }

    private boolean validateValueByType(Integer number, String color, TypeEnum typeEnum) {
        if (typeEnum.equals(TypeEnum.NUMBER)) {
            return number >= 0 && number <= 36;
        }
        return color.equals(RED) || color.equals(BLACK);
    }

    private void validateScoreArray(Roulette roulette, Bet bet) throws Exception {
        if (roulette.getBets().isEmpty() || roulette.getBets() == null) {
            LinkedList<Bet> list = new LinkedList<>();
            list.add(bet);
            roulette.setBets(list);
        } else {
            boolean isPresent = roulette.getBets().stream().anyMatch((b) ->
                    b.getUser().getId().equals(bet.getUser().getId()));
            if (isPresent)
                throw new Exception("Just one bet for user its allowed");
            else
                roulette.getBets().add(bet);
        }
    }

    private Bet buildRouletteBet(Integer number, String color, Double money, TypeEnum typeEnum, User user) {
        String value = typeEnum.equals(TypeEnum.NUMBER) ?
                String.valueOf(number) :
                color;
        return new Bet(value, money, user);
    }

    public Map<String, BetOutput> closing(String rouletteId) throws Exception {
        Roulette roulette = repository.findById(rouletteId);
        if (rouletteId == null) {
            throw new Exception("Null input");
        } else if (roulette == null) {
            throw new Exception("Roulette doesn't exist");
        } else if (roulette.getStatus() == Boolean.FALSE) {
            throw new Exception("Roulette is alredy close");
        } else {
            roulette.setStatus(Boolean.FALSE);
            Integer resultNumber = RandomWinnerGenerator.RandomNum();
            repository.updateStatus(roulette);
            return buildClose(roulette, resultNumber);
        }
    }

    public Map<String, BetOutput> buildClose(Roulette roulette, int resultNum) {
        List<Bet> winners = new LinkedList<>();
        List<Bet> losers = new LinkedList<>();
        ColorsEnum colors = ColorsEnum.BLACK;
        if ((resultNum % 2) == 0) {
            colors = ColorsEnum.RED;
        }
        for (Bet bet : roulette.getBets()) {
            buildResults(resultNum, winners, losers, colors, bet);
        }
        Map<String, BetOutput> result = new LinkedHashMap<>();
        result.put("result", new BetOutput(resultNum, colors.getColor(), winners.size(), losers.size(), winners, losers));
        return result;
    }

    private void buildResults(Integer resultNum, List<Bet> winners, List<Bet> losers, ColorsEnum colorsEnum,
                              Bet bet) {
        if (bet.getBet().equals(colorsEnum.getColor())){
            bet.getUser().setBalance(bet.getUser().getBalance() + (bet.getMoney() * 1.8));
            winners.add(bet);
        }else if (bet.getBet().equals(String.valueOf(resultNum))) {
            bet.getUser().setBalance(bet.getUser().getBalance() + (bet.getMoney() * 5));
            winners.add(bet);
        } else {
            bet.getUser().setBalance(bet.getUser().getBalance() - bet.getMoney());
            losers.add(bet);
        }
        userRepository.save(bet.getUser());
    }

}
