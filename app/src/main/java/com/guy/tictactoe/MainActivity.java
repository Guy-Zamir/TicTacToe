package com.guy.tictactoe;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnQuit, btnPvp, btnPvc, btnSettings;
    final int settings = 1;
    int markerIDX = R.drawable.x;
    int markerIDO = R.drawable.o;
    String nameX = "Player X";
    String nameO = "Player O";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPvc = findViewById(R.id.btnPvc);
        btnPvp = findViewById(R.id.btnPvp);
        btnSettings = findViewById(R.id.btnSettings);
        btnQuit = findViewById(R.id.btnQuit);

        btnPvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.guy.tictactoe.Game.class);
                intent.putExtra("pvc", false);
                intent.putExtra("markerIDX", markerIDX);
                intent.putExtra("markerIDO", markerIDO);
                intent.putExtra("nameX", nameX);
                intent.putExtra("nameO", nameO);
                startActivity(intent);
            }
        });

        btnPvc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.guy.tictactoe.Game.class);
                intent.putExtra("pvc", true);
                intent.putExtra("markerIDX", markerIDX);
                intent.putExtra("markerIDO", markerIDO);
                intent.putExtra("nameX", nameX);
                intent.putExtra("nameO", nameO);
                startActivity(intent);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsX.class);
                startActivityForResult(intent, settings);

            }
        });

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == settings) {
            markerIDO = data.getIntExtra("markerIDO", 0);
            markerIDX = data.getIntExtra("markerIDX", 0);
            nameX = data.getStringExtra("nameX");
            nameO = data.getStringExtra("nameO");
        }
    }
}
