package com.josardiaz.domain;

import java.io.Serializable;
import java.util.LinkedList;

public class Roulette implements Serializable {

    private String id;
    private boolean status;
    private LinkedList<Bet> bets = new LinkedList<>();

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
