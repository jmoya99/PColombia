package com.example.pcolombia;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class editar_usuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#EE7729")));
        getSupportActionBar().setTitle("Editar Usuario");
    }
}