package com.example.pcolombia.view.user;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.pcolombia.R;
import com.example.pcolombia.controller.user.CreateUserController;

public class CreateUserActivity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText password;
    private Spinner rol;
    private CreateUserController createUserController;
    
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(
                Color.parseColor(getString(R.color.orange))));
        getSupportActionBar().setTitle(getString(R.string.title_createUser));

        name = findViewById(R.id.nameTextView_createUser);
        email = findViewById(R.id.emailTextView_createUser);
        password = findViewById(R.id.passwordTextView_createUser);
        rol = (Spinner) findViewById(R.id.rolSpinner_createUser);

        //Codigo para poner los items en el spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.rolUserItems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rol.setAdapter(adapter);

        createUserController = new CreateUserController();
    }

    public void createUser(View view){
        String nameText = name.getText().toString();
        String emailText = email.getText().toString();
        String passwordText = password.getText().toString();
        String rolText = rol.getSelectedItem().toString();
        createUserController.createUser(this, nameText, emailText, passwordText, rolText);
    }

    public void missingField(){
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

    public void duplicatedEmail(){
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

}