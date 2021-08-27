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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.pcolombia.MainActivity;
import com.example.pcolombia.R;
import com.example.pcolombia.controller.usuario.CrearUsuarioController;

public class CrearUsuarioActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText correo;
    private EditText contraseña;
    private Spinner rol;
    private CrearUsuarioController crearUsuarioController;
    
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuario);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(
                Color.parseColor(getString(R.color.orange))));
        getSupportActionBar().setTitle(getString(R.string.titulo_crearUsuario));

        nombre = findViewById(R.id.nombreTextView_crearUsuario);
        correo = findViewById(R.id.correoTextView_crearUsuario);
        contraseña = findViewById(R.id.contrasenaTextView_crearUsuario);
        rol = (Spinner) findViewById(R.id.rolSpinner_crearUsuario);

        //Codigo para poner los items en el spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.rolUsuarioItems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rol.setAdapter(adapter);

        crearUsuarioController = new CrearUsuarioController();
    }

    public void crearUsuario(View view){
        String nombreText = nombre.getText().toString();
        String correoText = correo.getText().toString();
        String contraseñaText = contraseña.getText().toString();
        String rolText = rol.getSelectedItem().toString();
        crearUsuarioController.crearUsuario(this, nombreText, correoText, contraseñaText, rolText);
    }

    public void campoFaltante(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("por favor llenar todos los campos")
                .setTitle("Algo fue Mal")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void correoDuplicado(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Este correo ya está registrado")
                .setTitle("Algo fue Mal")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void irAValidarUsuario(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void cancelar(View view){
        irAValidarUsuario();
    }
}