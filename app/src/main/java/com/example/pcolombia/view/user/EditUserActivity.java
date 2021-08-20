package com.example.pcolombia.view.user;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.pcolombia.R;

public class EditUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#EE7729")));
        getSupportActionBar().setTitle("Editar Usuario");
    }
}