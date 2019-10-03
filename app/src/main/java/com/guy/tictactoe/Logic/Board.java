package com.guy.tictactoe.Logic;

import java.util.LinkedList;

public class Board {
    private int size;
    private LinkedList<Position> positions;
    private int blankID;

    public Board(int blank) {
        this.size = 3;
        this.positions = new LinkedList<>();
        this.blankID = blank;
    }

    public int getSize() {
        return size;
    }

    public LinkedList<Position> getPositions() {
        return positions;
    }

    public int getBlankID() {
        return blankID;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
