package com.guy.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsO extends AppCompatActivity {

    TextView tvChooseO;
    EditText etNameO;
    ImageView ivEldarO, ivGuyO, ivTalO, ivNitzanO, ivKobiO, ivTamratO;
    Button btnSubmitO;
    int markerIDX;
    int markerIDO = 0;
    String nameO = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_o);

        tvChooseO = findViewById(R.id.tvChooseO);
        etNameO = findViewById(R.id.etNameO);
        ivEldarO = findViewById(R.id.ivEldarO);
        ivGuyO = findViewById(R.id.ivGuyO);
        ivKobiO = findViewById(R.id.ivKobiO);
        ivNitzanO = findViewById(R.id.ivNitzanO);
        ivTalO = findViewById(R.id.ivTalO);
        ivTamratO = findViewById(R.id.ivTamratO);
        btnSubmitO = findViewById(R.id.btnSubmitO);
        markerIDX = getIntent().getIntExtra("markerIDX", 0);

        ivTamratO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                markerCheck(R.drawable.tamrat);
            }
        });

        ivTalO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                markerCheck(R.drawable.tal);
            }
        });

        ivNitzanO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                markerCheck(R.drawable.nitzan);
            }
        });

        ivGuyO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                markerCheck(R.drawable.guy);
            }
        });

        ivKobiO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                markerCheck(R.drawable.kobi);
            }
        });

        ivEldarO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                markerCheck(R.drawable.eldar);
            }
        });

        btnSubmitO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                nameO = etNameO.getText().toString();
                if (markerIDO == 0) {
                    Toast.makeText(SettingsO.this, "Select a Marker!", Toast.LENGTH_SHORT).show();
                } else {
                    intent.putExtra("nameO", nameO);
                    intent.putExtra("markerIDO", markerIDO);
                    intent.putExtra("markerIDX", markerIDX);
                    setResult(RESULT_OK, intent);
                    SettingsO.this.finish();
                }
            }
        });
    }

    public void markerCheck(int marker) {
        if (markerIDX == marker) {
            Toast.makeText(this, "Player X has that marker, choose another one", Toast.LENGTH_SHORT).show();
        } else {
            markerIDO = marker;
            Toast.makeText(this, "Nice Choice!", Toast.LENGTH_SHORT).show();
        }
    }
}
