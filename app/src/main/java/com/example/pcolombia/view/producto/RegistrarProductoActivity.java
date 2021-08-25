package com.example.pcolombia.view.producto;

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
import com.example.pcolombia.controller.producto.RegistrarProductoController;

public class RegistrarProductoActivity extends AppCompatActivity {

    private EditText nombreEditText;
    private EditText marcaEditText;
    private EditText precioEditText;
    private Spinner tipoSpinner;
    private EditText cantidadEditText;
    private EditText descripcionEditText;
    private RegistrarProductoController controller;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_producto);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(
                Color.parseColor(getString(R.color.orange))));
        getSupportActionBar().setTitle(getString(R.string.titulo_registrarProducto));
        nombreEditText = findViewById(R.id.nombreTextView_registrarProducto);
        marcaEditText = findViewById(R.id.marcaTextView_registrarProducto);
        precioEditText = findViewById(R.id.precioTextView_registrarProducto);
        tipoSpinner = (Spinner) findViewById(R.id.tipoSpinner_registrarProducto);
        cantidadEditText = findViewById(R.id.cantidadTextView_registrarProducto);
        descripcionEditText = findViewById(R.id.descripcionTextView_registrarProducto);

        //Codigo para poner los items en el spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tipoProductoItems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoSpinner.setAdapter(adapter);
        controller = new RegistrarProductoController();
    }

    public void registrarProducto(View view){
        String nombreText = nombreEditText.getText().toString();
        String marcaText = marcaEditText.getText().toString();
        String precioText = precioEditText.getText().toString();
        String tipoText = tipoSpinner.getSelectedItem().toString();
        String cantidadText = cantidadEditText.getText().toString();
        String descripcionText = descripcionEditText.getText().toString();
        controller.registrarProducto(this, nombreText,marcaText,precioText,
                tipoText, cantidadText, descripcionText);
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
}