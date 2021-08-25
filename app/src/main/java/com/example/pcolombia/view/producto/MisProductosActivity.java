package com.example.pcolombia.view.producto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.example.pcolombia.MainActivity;
import com.example.pcolombia.controller.producto.MisProductosController;
import com.example.pcolombia.view.producto.fragment.ProductoFragment;
import com.example.pcolombia.R;
import com.example.pcolombia.view.usuario.GestionarUsuarioActivity;

public class MisProductosActivity extends AppCompatActivity {

    private String correoVendedor;
    private MisProductosController misProductosController;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_productos);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(
                Color.parseColor(getString(R.color.orange))));
        getSupportActionBar().setTitle(getString(R.string.titulo_misProductos));
        String correo = getIntent().getExtras().getString("correo_usuario");
        correo = correo != null ? correo : "";
        setCorreoVendedor(correo);
        misProductosController.cargarProductos(this);
    }

    public void irAGestionarUsuario(View view){
        Intent intent = new Intent(this, GestionarUsuarioActivity.class);
        intent.putExtra("correo_usuario",getCorreoVendedor());
        startActivity(intent);
    }

    public void irARegistrarProducto(View view){
        Intent intent = new Intent(this,RegistrarProductoActivity.class);
        intent.putExtra("correo_usuario",getCorreoVendedor());
        startActivity(intent);
    }

    public void irAValidarUsuario(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void irAGestionarProducto(int id){
        Intent intent = new Intent(this,GestionarProductoActivity.class);
        intent.putExtra("correo_usuario",getCorreoVendedor());
        intent.putExtra("id", id);
        startActivity(intent);
    }

    public void agregarProducto(int id, String nombre, String marca, String precio, String estado, String visibilidad){
        getSupportFragmentManager().beginTransaction().add(R.id.listaProductosLinearLayout_misProductos,
                ProductoFragment.newInstance(id, nombre,marca,precio,estado,visibilidad,this)).commit();
    }

    public String getCorreoVendedor() {
        return correoVendedor;
    }

    public void setCorreoVendedor(String correoVendedor) {
        this.correoVendedor = correoVendedor;
    }
}