package com.example.pcolombia.view.user;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.example.pcolombia.controller.user.ManageUserController;

import static com.example.pcolombia.R.*;

public class ManageUserActivity extends AppCompatActivity {

    private ManageUserController controller;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_manage_user);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(
                Color.parseColor(getString(color.orange))));
        getSupportActionBar().setTitle(getString(string.title_manageUser));
        controller = new ManageUserController();
    }

    public void removeUser(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Esta seguro de eliminar su usuario?")
                .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .setNegativeButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        controller.removeUser();
                        dialogInterface.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}