package com.josardiaz.domain;

import java.io.Serializable;
import java.util.List;

public class BetOutput implements Serializable {

    private int resultNumber;
    private String resultColor;
    private int winners;
    private int losers;
    private List<Bet> listOfWinners;
    private List<Bet> listOfLosers;

    public BetOutput(int resultNumber, String resultColor, int winners,
                     int losers, List<Bet> listOfWinners, List<Bet> listOfLosers) {
        this.resultNumber = resultNumber;
        this.resultColor = resultColor;
        this.winners = winners;
        this.losers = losers;
        this.listOfWinners = listOfWinners;
        this.listOfLosers = listOfLosers;
    }

    public int getResultNumber() {
        return resultNumber;
    }

    public void setResultNumber(int resultNumber) {
        this.resultNumber = resultNumber;
    }

    public String getResultColor() {
        return resultColor;
    }

    public void setResultColor(String resultColor) {
        this.resultColor = resultColor;
    }

    public int getWinners() {
        return winners;
    }

    public void setWinners(int winners) {
        this.winners = winners;
    }

    public int getLosers() {
        return losers;
    }

    public void setLosers(int losers) {
        this.losers = losers;
    }

    public List<Bet> getListOfWinners() {
        return listOfWinners;
    }

    public void setListOfWinners(List<Bet> listOfWinners) {
        this.listOfWinners = listOfWinners;
    }

    public List<Bet> getListOfLosers() {
        return listOfLosers;
    }

    public void setListOfLosers(List<Bet> listOfLosers) {
        this.listOfLosers = listOfLosers;
    }
}
