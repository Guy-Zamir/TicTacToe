package com.guy.tictactoe.Logic;

public class Player {
    private String name;
    private int markerID;

    public Player(String name, int marker) {
        this.name = name;
        this.markerID = marker;
    }

    public String getName() {
        return name;
    }

    public int getMarkerID() {
        return markerID;
    }
}
