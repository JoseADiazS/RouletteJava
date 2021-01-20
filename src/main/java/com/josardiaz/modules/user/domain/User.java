package com.josardiaz.modules.user.domain;

import java.io.Serializable;

public class User implements Serializable {

    private String id;
    private String userName;
    private double balance;

    public User(String id, String userName, double balance) {
        this.id = id;
        this.userName = userName;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
