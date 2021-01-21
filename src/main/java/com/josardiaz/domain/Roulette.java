package com.josardiaz.domain;

import java.io.Serializable;
import java.util.LinkedList;

public class Roulette implements Serializable {

    private String id;
    private boolean status;
    private LinkedList<Bet> bets = new LinkedList<>();

    // Java Longs ends with L
    // This variable prevents this exception:
    // ava.io.InvalidClassException: com.josardiaz.domain.Roulette;
    // local class incompatible: stream classdesc serialVersionUID = -3764582127773480896,
    // local class serialVersionUID = 6543487073555988897
    private static final long serialVersionUID = -3764582127773480896L;

    public Roulette() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LinkedList<Bet> getBets() {
        return bets;
    }

    public void setBets(LinkedList<Bet> bets) {
        this.bets = bets;
    }



}
