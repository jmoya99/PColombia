package com.example.pcolombia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.pcolombia.view.user.CreateUserActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#EE7729")));
        getSupportActionBar().setTitle("PColombia");*/
        getSupportActionBar().hide();

    }
}