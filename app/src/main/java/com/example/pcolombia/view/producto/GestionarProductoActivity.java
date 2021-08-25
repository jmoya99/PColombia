package com.example.pcolombia.view.producto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pcolombia.R;
import com.example.pcolombia.controller.producto.GestionarProductoController;

public class GestionarProductoActivity extends AppCompatActivity {

    private TextView nombreTextView;
    private TextView marcaTextView;
    private TextView precioTextView;
    private TextView tipoTextView;
    private TextView estadoTextView;
    private TextView visibilidadTextView;
    private TextView descripcionTextView;
    private TextView cantidadTextView;
    private Button publicarOcultarButton;
    private GestionarProductoController controller;
    private String correoVendedor;
    private int ID;

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
        publicarOcultarButton = findViewById(R.id.publicarOcultarButton_gestionarProducto);

        String correo = getIntent().getExtras().getString("correo_usuario");
        correo = correo != null ? correo : "";
        setCorreoVendedor(correo);

        int id = getIntent().getExtras().getInt("id");
        setID(id);
        controller = new GestionarProductoController();
        controller.cargarProducto(this,getID());
    }

    public void cargarCampos(String nombre, String marca, String precio, String tipo, String estado,
                             String visibilidad, String descripcion, String cantidad,
                             String publicarOcultar){
        nombreTextView.setText(nombre);
        marcaTextView.setText(marca);
        precioTextView.setText(precio);
        tipoTextView.setText(tipo);
        estadoTextView.setText(estado);
        visibilidadTextView.setText(visibilidad);
        descripcionTextView.setText(descripcion);
        cantidadTextView.setText(cantidad);
        publicarOcultarButton.setText(publicarOcultar);
    }

    public void eliminarProducto(View view){
        GestionarProductoActivity gestionarProductoActivity = this;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("“¿Está seguro de publicar este producto?”")
                .setPositiveButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .setNegativeButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        controller.eliminarProducto(gestionarProductoActivity,getID());
                        dialogInterface.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void publicarOcultarProducto(View view){
        controller.publicarOcultarProducto(this, getID());
    }

    public void irAMisProductos(){
        Intent intent = new Intent(this,MisProductosActivity.class);
        intent.putExtra("correo_usuario",getCorreoVendedor());
        startActivity(intent);
        finish();
    }

    public void irAEditarProducto(View view){
        Intent intent = new Intent(this,EditarProductoActivity.class);
        intent.putExtra("correo_usuario",getCorreoVendedor());
        intent.putExtra("id", getID());
        startActivity(intent);
    }

    public void irAMisProductos(View view){
        Intent intent = new Intent(this, MisProductosActivity.class);
        intent.putExtra("correo_usuario",getCorreoVendedor());
        startActivity(intent);
    }

    public String getCorreoVendedor() {
        return correoVendedor;
    }

    public void setCorreoVendedor(String correoVendedor) {
        this.correoVendedor = correoVendedor;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}