package com.example.pcolombia.view.usuario;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pcolombia.MainActivity;
import com.example.pcolombia.R;
import com.example.pcolombia.controller.usuario.GestionarUsuarioController;
import com.example.pcolombia.view.producto.GestionarProductoActivity;
import com.example.pcolombia.view.producto.MisProductosActivity;

import static com.example.pcolombia.R.*;

public class GestionarUsuarioActivity extends AppCompatActivity {

    private String correoVendedor;
    private TextView nombreTextView;
    private TextView correoTextView;
    private TextView contrasenaTextView;
    private TextView rolTextView;
    private GestionarUsuarioController controller;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_gestionar_usuario);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(
                Color.parseColor(getString(color.orange))));
        getSupportActionBar().setTitle(getString(string.titulo_gestionarUsuario));
        nombreTextView = findViewById(id.nombreTextView_gestionarUsuario);
        correoTextView = findViewById(id.correoTextView_gestionarUsuario);
        contrasenaTextView = findViewById(id.contrasenaTextView_gestionarUsuario);
        rolTextView = findViewById(id.rolTextView_gestionarUsuario);
        String correo = getIntent().getExtras().getString("correo_usuario");
        correo = correo != null ? correo : "";
        setCorreoVendedor(correo);
        controller = new GestionarUsuarioController();
        controller.cargarUsuario(this, getCorreoVendedor());
    }

    public void eliminarUsuario(View view){
        GestionarUsuarioActivity gestionarUsuarioActivity = this;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Esta seguro de eliminar su usuario?")
                .setPositiveButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .setNegativeButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        controller.eliminarUsuario(gestionarUsuarioActivity, getCorreoVendedor());
                        dialogInterface.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void irAEditarUsuario(View view){
        Intent intent = new Intent(this, EditarUsuarioActivity.class);
        intent.putExtra("correo_usuario",getCorreoVendedor());
        startActivity(intent);
        finish();
    }

    public void cargarCampos(String nombre, String correo, String contrasena, String rol){
        nombreTextView.setText(nombre);
        correoTextView.setText(correo);
        contrasenaTextView.setText(contrasena);
        rolTextView.setText(rol);
    }

    public void irAMisProductos(View view){
        Intent intent = new Intent(this, MisProductosActivity.class);
        intent.putExtra("correo_usuario",getCorreoVendedor());
        startActivity(intent);
        finish();
    }

    public void irAValidarUSuario(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public String getCorreoVendedor() {
        return correoVendedor;
    }

    public void setCorreoVendedor(String correoVendedor) {
        this.correoVendedor = correoVendedor;
    }
}