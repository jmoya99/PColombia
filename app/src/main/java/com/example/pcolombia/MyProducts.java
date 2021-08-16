package com.example.pcolombia;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class MyProducts extends AppCompatActivity {

    private String[] visibilidadDePrueba = {"Publica","Privada"};
    private String[] estadoDePrueba = {"Disponible","No Disponible"};

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_products);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(
                Color.parseColor(getString(R.color.orange))));
        getSupportActionBar().setTitle(getString(R.string.title_myProducts));
        for (int i = 1;i < 20;i++){
            getSupportFragmentManager().beginTransaction().add(R.id.productListLinearLayout_myProducts,
                    ProductFragment.newInstance("Producto "+i,"Marca "+i,
                            "$ "+(i*(100100+i)),estadoDePrueba[i%2],visibilidadDePrueba[i%2]))
                    .commit();
        }
    }
}