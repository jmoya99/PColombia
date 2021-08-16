package com.example.pcolombia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#EE7729")));
        getSupportActionBar().setTitle("PColombia");*/
        getSupportActionBar().hide();
    }

    public void pasarPestena(View view){
        Intent activity = new Intent(this, MyProducts.class);
        startActivity(activity);
    }
}