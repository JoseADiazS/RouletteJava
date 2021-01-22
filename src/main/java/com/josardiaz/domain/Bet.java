package com.josardiaz.domain;

import java.io.Serializable;

public class Bet implements Serializable {

    private static final long serialVersionUID = -750610277282912634L;
    private String bet;
    private Double money;
    private User user;

    public Bet(String bet, Double money, User user) {
        this.bet = bet;
        this.money = money;
        this.user = user;
    }

    public String getBet() {
        return bet;
    }

    public void setBet(String bet) {
        this.bet = bet;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
