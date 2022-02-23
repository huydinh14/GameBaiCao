package com.example.GameBaiCao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity_ChooseGame extends AppCompatActivity {
    Button btnMayVoiMay, btnNguoiVoiMay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_choose_game);
        AnhXa();

        btnNguoiVoiMay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity_ChooseGame.this, MainActivity_GameFirst.class);
                startActivity(intent);
            }
        });

        btnMayVoiMay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity_ChooseGame.this, MainActivity_TimePlay.class);
                startActivity(intent);
            }
        });
    }

    private void AnhXa() {
        btnNguoiVoiMay = findViewById(R.id.btnNguoiVoiMay);
        btnMayVoiMay = findViewById(R.id.btnMayVoiMay);
    }
}