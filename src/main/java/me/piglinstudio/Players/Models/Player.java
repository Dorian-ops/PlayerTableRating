package me.piglinstudio.Players.Models;

public class Player {
    private String playerName;
    private int points;

    public void setPlayerName(String name) {
        this.playerName = name;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPoints() {
        return points;
    }
}
