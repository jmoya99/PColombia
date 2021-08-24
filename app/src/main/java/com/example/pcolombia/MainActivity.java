package com.example.pcolombia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.pcolombia.controller.usuario.ValidarUsuarioController;
import com.example.pcolombia.view.user.CrearUsuarioActivity;

public class MainActivity extends AppCompatActivity {

    private EditText correo;
    private EditText contraseña;
    private ValidarUsuarioController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        correo = findViewById(R.id.emailTextView_personValidate);
        contraseña = findViewById(R.id.passwordTextView_personValidate);
        controller = new ValidarUsuarioController();
        Intent activity = new Intent(this, CrearUsuarioActivity.class);
        startActivity(activity);
    }

    public void validarUsuario(View view){
        String correoText = correo.getText().toString();
        String contraseñaText = contraseña.getText().toString();
        controller.validarUsuario(this, correoText, contraseñaText);
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
}