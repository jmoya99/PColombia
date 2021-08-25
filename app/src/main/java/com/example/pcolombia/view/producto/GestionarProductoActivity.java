package com.example.pcolombia.view.producto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pcolombia.R;

public class GestionarProductoActivity extends AppCompatActivity {

    private TextView nombreTextView;
    private TextView marcaTextView;
    private TextView precioTextView;
    private TextView tipoTextView;
    private TextView estadoTextView;
    private TextView visibilidadTextView;
    private TextView descripcionTextView;
    private TextView cantidadTextView;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionar_producto);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(
                Color.parseColor(getString(R.color.orange))));
        getSupportActionBar().setTitle(getString(R.string.titulo_gestionarProducto));

        nombreTextView = findViewById(R.id.nombreTextView_gestionarProducto);
        marcaTextView = findViewById(R.id.marcaTextView_gestionarProducto);
        precioTextView = findViewById(R.id.precioTextView_gestionarProducto);
        tipoTextView = findViewById(R.id.tipoTextView_gestionarProducto);
        estadoTextView = findViewById(R.id.estadoTextView_gestionarProducto);
        visibilidadTextView = findViewById(R.id.visibilidadTextView_gestionarProducto);
        descripcionTextView = findViewById(R.id.descripcionTextView_gestionarProducto);
        cantidadTextView = findViewById(R.id.cantidadTextView_gestionarProducto);
    }

    public void cargarCampos(String nombre, String marca, String precio, String tipo, String estado,
                             String visibilidad, String descripcion, String cantidad){
        nombreTextView.setText(nombre);
        marcaTextView.setText(marca);
        precioTextView.setText(precio);
        tipoTextView.setText(tipo);
        estadoTextView.setText(estado);
        visibilidadTextView.setText(visibilidad);
        descripcionTextView.setText(descripcion);
        cantidadTextView.setText(cantidad);
    }
}