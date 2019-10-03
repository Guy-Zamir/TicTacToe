package com.guy.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.guy.tictactoe.Logic.Position;
import java.util.ArrayList;

public class Game extends AppCompatActivity {

    com.guy.tictactoe.Logic.Game game;
    ArrayList<ImageView> imagePos;
    TextView tvMessage;
    Button btnBack, btnReplay, btnExit;
    int markerIDO, markerIDX;
    String nameX, nameO, message;
    boolean pvc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        pvc = getIntent().getBooleanExtra("pvc", false);
        nameO = getIntent().getStringExtra("nameO");
        nameX = getIntent().getStringExtra("nameX");
        markerIDO = getIntent().getIntExtra("markerIDO", 0);
        markerIDX = getIntent().getIntExtra("markerIDX", 0);

        game = new com.guy.tictactoe.Logic.Game(R.drawable.blank, markerIDX, markerIDO, nameX, nameO, pvc);
        imagePos = new ArrayList<>();

        for (int i = 0; i < Math.pow(game.getBoard().getSize(), 2); i++) {
            String ivID = "iv" + i;
            int resID = getResources().getIdentifier(ivID, "id", getPackageName());
            ImageView iv = findViewById(resID);
            imagePos.add(iv);
            game.getBoard().getPositions().add(new Position(imagePos.get(i)));
        }

        tvMessage = findViewById(R.id.tvMessage);
        btnBack = findViewById(R.id.btnBack);
        btnReplay = findViewById(R.id.btnReplay);
        btnExit = findViewById(R.id.btnExit);

        game.setBlankBoard();
        setClickAble(true);
        message = "";
        displayTurn();

        imagePos.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn(0);
            }
        });

        imagePos.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn(1);
            }
        });

        imagePos.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn(2);
            }
        });

        imagePos.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn(3);
            }
        });

        imagePos.get(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn(4);
            }
        });

        imagePos.get(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn(5);
            }
        });

        imagePos.get(6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn(6);
            }
        });

        imagePos.get(7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn(7);
            }
        });

        imagePos.get(8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn(8);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (game.back()) {
                    if (pvc) {
                        game.back();
                    }
                    displayTurn();
                } else {
                    Toast.makeText(Game.this, "Start Playing!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.setBlankBoard();
                setClickAble(true);
                message = "";
                displayTurn();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void turn(int pos) {
        String move = game.turn(pos);
        switch (move) {
            case "noMove":
                Toast.makeText(Game.this, "You can't take that move!", Toast.LENGTH_SHORT).show();
                break;
            case "X":
                message = game.getPlayerX().getName() + " Has Won!";
                setClickAble(false);
                break;
            case "O":
                message = game.getPlayerO().getName() + " Has Won!";
                setClickAble(false);
                break;
            case "draw":
                message = "The board is full\nIt's a Draw!";
                setClickAble(false);
                break;
        }
        if (message.isEmpty()) {
            displayTurn();
        } else {
            setTextView(message);
        }
    }

    public void displayTurn() {
        if (game.isTurn()) {
            String xTurn = game.getPlayerX().getName() + " turn's\nPlace your position";
            setTextView(xTurn);
        } else {
            String oTurn = game.getPlayerO().getName() + " turn's\nPlace your position";
            setTextView(oTurn);
        }
    }

    public void setTextView(String message) {
        tvMessage.setText(message);
    }

    public void setClickAble(boolean click) {
        for (int i=0; i<Math.pow(game.getBoard().getSize(), 2); i++) {
            imagePos.get(i).setEnabled(click);
        }
        btnBack.setEnabled(click);
    }
}
