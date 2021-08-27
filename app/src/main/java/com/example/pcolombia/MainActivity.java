package com.example.pcolombia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.pcolombia.controller.usuario.ValidarUsuarioController;
import com.example.pcolombia.view.producto.MisProductosActivity;
import com.example.pcolombia.view.usuario.CrearUsuarioActivity;

public class MainActivity extends AppCompatActivity {

    private EditText correoEditText;
    private EditText contraseña;
    private ValidarUsuarioController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        correoEditText = findViewById(R.id.correoTextView_validarUsuario);
        contraseña = findViewById(R.id.contrasenaTextView_validarUsuario);
        controller = new ValidarUsuarioController();
    }

    public void validarUsuario(View view){
        String correoText = correoEditText.getText().toString();
        String contraseñaText = contraseña.getText().toString();
        controller.validarUsuario(this, correoText, contraseñaText);
    }

    public void cancelar(View view){
        finish();
    }

    public void campoFaltante(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("por favor llenar todos los campos\n")
                .setTitle("Algo fue Mal")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void correoOContraseñaIncorrectos(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Correo y/o contraseña incorrectos\n\n")
                .setTitle("Algo fue Mal")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void irAMisProductos(String correo){
        Intent intent = new Intent(this, MisProductosActivity.class);
        intent.putExtra("correo_usuario",correo);
        startActivity(intent);
        finish();
    }

    public void irACrearUsuario(View view){
        Intent intent = new Intent(this, CrearUsuarioActivity.class);
        startActivity(intent);
        finish();
    }
}