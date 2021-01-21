package com.josardiaz.domain;

import java.io.Serializable;

public class Bet implements Serializable {

    private String id;
    private User user;
    private double balance;

    public Bet(String id, User user, double balance) {
        this.id = id;
        this.user = user;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUserName(String userName) {
        this.user = user;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
