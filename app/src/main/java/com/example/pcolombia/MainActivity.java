package com.example.pcolombia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.pcolombia.controller.user.ValidateUserController;
import com.example.pcolombia.view.seller.EditProductActivity;
import com.example.pcolombia.view.seller.RegisterProductActivity;
import com.example.pcolombia.view.user.CreateUserActivity;
import com.example.pcolombia.view.user.ManageUserActivity;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private ValidateUserController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#EE7729")));
        getSupportActionBar().setTitle("PColombia");*/
        getSupportActionBar().hide();
        email = findViewById(R.id.emailTextView_personValidate);
        password = findViewById(R.id.passwordTextView_personValidate);
        controller = new ValidateUserController();
        Intent activity = new Intent(this, RegisterProductActivity.class);
        startActivity(activity);
    }

    public void signIn(View view){
        String emailText = email.getText().toString();
        String passwordText = password.getText().toString();
        controller.signIn(this, emailText, passwordText);
    }

    public void fieldMissing(){
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

    public void incorrectEmailOrPassword(){
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