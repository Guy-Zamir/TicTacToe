package com.guy.tictactoe;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsX extends AppCompatActivity {

    TextView tvChooseX;
    EditText etNameX;
    ImageView ivEldarX, ivGuyX, ivTalX, ivNitzanX, ivKobiX, ivTamratX;
    Button btnSubmitX;
    int markerIDX = 0;
    int markerIDO;
    String nameX = "";
    String nameO = "";
    final int settings = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_x);

        tvChooseX = findViewById(R.id.tvChooseX);
        etNameX = findViewById(R.id.etNameX);
        ivEldarX = findViewById(R.id.ivEldarX);
        ivGuyX = findViewById(R.id.ivGuyX);
        ivKobiX = findViewById(R.id.ivKobiX);
        ivNitzanX = findViewById(R.id.ivNitzanX);
        ivTalX = findViewById(R.id.ivTalX);
        ivTamratX = findViewById(R.id.ivTamratX);
        btnSubmitX = findViewById(R.id.btnSubmitX);

        ivTamratX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMarker(R.drawable.tamrat);
            }
        });

        ivTalX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMarker(R.drawable.tal);
            }
        });

        ivNitzanX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMarker(R.drawable.nitzan);
            }
        });

        ivGuyX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMarker(R.drawable.guy);
            }
        });

        ivKobiX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMarker(R.drawable.kobi);
            }
        });

        ivEldarX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMarker(R.drawable.eldar);
            }
        });

        btnSubmitX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsX.this, com.guy.tictactoe.SettingsO.class);
                nameX = etNameX.getText().toString();
                if (markerIDX == 0) {
                    Toast.makeText(SettingsX.this, "Select a Marker!", Toast.LENGTH_SHORT).show();
                } else {
                    intent.putExtra("markerIDX", markerIDX);
                    startActivityForResult(intent, settings);
                }
            }
        });
    }

    public void setMarker(int marker) {
        markerIDX = marker;
        Toast.makeText(this, "Nice Choice!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent intent = new Intent();

        nameO = data.getStringExtra("nameO");
        if (nameO.isEmpty()) {
            intent.putExtra("nameO", "Player O");
        } else {
            intent.putExtra("nameO", nameO);
        }

        markerIDO = data.getIntExtra("markerIDO", 0);
        intent.putExtra("markerIDO", markerIDO);

        markerIDX = data.getIntExtra("markerIDX", 0);
        intent.putExtra("markerIDX", markerIDX);

        if (nameX.isEmpty()) {
            intent.putExtra("nameX", "Player X");
        } else {
            intent.putExtra("nameX", nameX);
        }

        setResult(RESULT_OK, intent);
        SettingsX.this.finish();
    }
}