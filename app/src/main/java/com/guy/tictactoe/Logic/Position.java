package com.guy.tictactoe.Logic;

import android.widget.ImageView;

public class Position {
    private ImageView marker;
    private boolean blank;

    public Position(ImageView marker) {
        this.marker = marker;
        this.blank = true;
    }

    public ImageView getMarker() {
        return marker;
    }

    public boolean isBlank() {
        return blank;
    }

    public void setBlank(boolean blank) {
        this.blank = blank;
    }
}
