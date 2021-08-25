package com.example.pcolombia.view.usuario;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.pcolombia.R;
import com.example.pcolombia.controller.usuario.EditarUsuarioController;

public class EditarUsuarioActivity extends AppCompatActivity {

    private EditText nombreEditText;
    private EditText contrasenaEditText;
    private EditarUsuarioController editarUsuarioController;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(
                Color.parseColor(getString(R.color.orange))));
        getSupportActionBar().setTitle(getString(R.string.titulo_editarUsuario));

        nombreEditText = findViewById(R.id.nombreTextView_editarUsuario);
        contrasenaEditText = findViewById(R.id.contrasenaTextView_editarUsuario);

        editarUsuarioController = new EditarUsuarioController();
    }

    public void editarUsuario(View view){
        String nombreText = nombreEditText.getText().toString();
        String contrasenaText = contrasenaEditText.getText().toString();
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

    public void cargarCampos(String nombre,String contrasena){
        nombreEditText.setText(nombre);
        contrasenaEditText.setText(contrasena);
    }

}