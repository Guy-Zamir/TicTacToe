package com.guy.tictactoe.Logic;
import android.graphics.drawable.Drawable;

import java.util.LinkedList;

public class Game {

    private Board board;
    private Player playerX;
    private Player playerO;
    private boolean turn;
    private boolean pvc;
    private LinkedList<Integer> moveHistory;

    public Game(int blank, int markerXID, int markerOID, String nameX, String nameO, boolean pvc) {
        this.board = new Board(blank);
        this.playerX = new Player(nameX, markerXID);
        this.playerO = new Player(nameO, markerOID);
        this.turn = true;
        this.pvc = pvc;
        this.moveHistory = new LinkedList<>();
    }

    public boolean back() {
        if (moveHistory.size() != 0) {
            int pos = moveHistory.getLast();
            int blank = board.getBlankID();
            board.getPositions().get(pos).getMarker().setImageResource(blank);
            board.getPositions().get(pos).setBlank(true);
            turn = !turn;
            moveHistory.remove(moveHistory.size()-1);
            return true;
        }
        return false;
    }

    public String turn(int pos) {
        int markerID = markerTurn();
        if (!setPosition(markerID, pos)) {
            return "noMove";
        } else if (winCheck()) {
            if (turn) {
                return "X";
            } else {
                return "O";
            }
        } else if (boardIsFull()) {
            return "draw";
        }
        turn = !turn;
        if (pvc && !turn) {
            return pvcTurn();
        }
        return "OK";
    }

    private String pvcTurn() {
        int markerID;
        markerID = markerTurn();
        setRandomPosition(markerID);
        if (winCheck()) {
            if (turn) {
                return "X";
            } else {
                return "O";
            }
        } else if (boardIsFull()) {
            return "draw";
        }
        turn = !turn;
        return "OK";
    }

    private int markerTurn() {
        if (turn) {
            return playerX.getMarkerID();
        } else {
            return playerO.getMarkerID();
        }
    }

    private boolean winCheck() {
        Drawable.ConstantState pos0 = getBoard().getPositions().get(0).getMarker().getDrawable().getConstantState();
        Drawable.ConstantState pos1 = getBoard().getPositions().get(1).getMarker().getDrawable().getConstantState();
        Drawable.ConstantState pos2 = getBoard().getPositions().get(2).getMarker().getDrawable().getConstantState();
        Drawable.ConstantState pos3 = getBoard().getPositions().get(3).getMarker().getDrawable().getConstantState();
        Drawable.ConstantState pos4 = getBoard().getPositions().get(4).getMarker().getDrawable().getConstantState();
        Drawable.ConstantState pos5 = getBoard().getPositions().get(5).getMarker().getDrawable().getConstantState();
        Drawable.ConstantState pos6 = getBoard().getPositions().get(6).getMarker().getDrawable().getConstantState();
        Drawable.ConstantState pos7 = getBoard().getPositions().get(7).getMarker().getDrawable().getConstantState();
        Drawable.ConstantState pos8 = getBoard().getPositions().get(8).getMarker().getDrawable().getConstantState();
        return ((pos0 == pos1 && pos1 == pos2 && !board.getPositions().get(0).isBlank()) ||
                (pos3 == pos4 && pos4 == pos5 && !board.getPositions().get(3).isBlank())) ||
                (pos6 == pos7 && pos7 == pos8 && !board.getPositions().get(6).isBlank()) ||
                (pos0 == pos3 && pos3 == pos6 && !board.getPositions().get(0).isBlank()) ||
                (pos1 == pos4 && pos4 == pos7 && !board.getPositions().get(1).isBlank()) ||
                (pos2 == pos5 && pos5 == pos8 && !board.getPositions().get(2).isBlank()) ||
                (pos0 == pos4 && pos4 == pos8 && !board.getPositions().get(0).isBlank() ||
                        (pos2 == pos4 && pos4 == pos6 && !board.getPositions().get(2).isBlank()));
    }

    private boolean boardIsFull() {
        for (int i = 0; i < board.getPositions().size(); i++) {
            if (board.getPositions().get(i).isBlank()) {
                return false;
            }
        }
        return true;
    }

    private void setRandomPosition(int markerID) {
        while(true) {
            int pos = randomNum();
            if (board.getPositions().get(pos).isBlank()) {
                board.getPositions().get(pos).getMarker().setImageResource(markerID);
                board.getPositions().get(pos).setBlank(false);
                moveHistory.add(pos);
                break;
            }
        }
    }

    private boolean setPosition(int markerID, int position) {
        if (board.getPositions().get(position).isBlank()) {
            board.getPositions().get(position).getMarker().setImageResource(markerID);
            board.getPositions().get(position).setBlank(false);
            moveHistory.add(position);
            return true;
        }
        return false;
    }

    public void setBlankBoard() {
        for (int i = 0; i < board.getSize() * board.getSize(); i++) {
            board.getPositions().get(i).getMarker().setImageResource(board.getBlankID());
            board.getPositions().get(i).setBlank(true);
        }
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayerX() {
        return playerX;
    }

    public Player getPlayerO() {
        return playerO;
    }

    public boolean isTurn() {
        return turn;
    }

    private static int randomNum() {
        return((int)(Math.random()*(8 + 1)));
    }
}
