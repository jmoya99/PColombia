package com.example.pcolombia.view.user;

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
import com.example.pcolombia.controller.user.CreateUserController;

import static com.example.pcolombia.R.color.orange;

public class CreateUserActivity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText password;
    private CreateUserController createUserController;
    
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(
                Color.parseColor(getString(orange))));
        getSupportActionBar().setTitle("Crear Usuario");

        name = findViewById(R.id.nameET_createUser);
        email = findViewById(R.id.correoET_createUser);
        password = findViewById(R.id.contraseñaET_createUser);

        createUserController = new CreateUserController();
    }

    public void createUser(View view){
        String nameText = name.getText().toString();
        String emailText = email.getText().toString();
        String passwordText = password.getText().toString();
        createUserController.createUser(this, nameText, emailText, passwordText);
    }

    public void nameIsMandatoryMandatory(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Nombre es Obligatorio")
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

    public void emailIsMandatoryMandatory(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Correo es Obligatorio")
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

    public void passwordIsMandatoryMandatory(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("COnstraseña es Obligatorio")
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
}