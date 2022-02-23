package com.example.GameBaiCao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity_TimePlay extends AppCompatActivity {
    Button btnBatDau;
    EditText etThoiGianChoi;
    ImageView ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_time_play);
        AnhXa();
        btnBatDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity_TimePlay.this, MainActivity_GameSecond.class);
                intent.putExtra("TimePlay",etThoiGianChoi.getText().toString());
                startActivity(intent);
            }
        });

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity_TimePlay.this, MainActivity_ChooseGame.class);
                startActivity(intent);
            }
        });
    }
    private void AnhXa() {
        btnBatDau = findViewById(R.id.button_BatDauGame);
        etThoiGianChoi = findViewById(R.id.editText_TimePlay);
        ivBack = findViewById(R.id.imageBackTimeMenu);
    }
}