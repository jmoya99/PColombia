package com.example.pcolombia.view.producto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.pcolombia.view.producto.fragment.ProductoFragment;
import com.example.pcolombia.R;

public class MisProductosActivity extends AppCompatActivity {

    private String[] visibilidadDePrueba = {"Publica","Privada"};
    private String[] estadoDePrueba = {"Disponible","No Disponible"};

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_productos);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(
                Color.parseColor(getString(R.color.orange))));
        getSupportActionBar().setTitle(getString(R.string.titulo_misProductos));
    }
}