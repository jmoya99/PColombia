package com.example.pcolombia.view.seller;

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
import com.example.pcolombia.controller.product.RegistrarProductoController;

public class RegistrarProductoActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText marca;
    private EditText precio;
    private Spinner tipo;
    private EditText cantidad;
    private EditText descripcion;
    private RegistrarProductoController controller;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_product);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(
                Color.parseColor(getString(R.color.orange))));
        getSupportActionBar().setTitle(getString(R.string.title_registerProduct));
        nombre = findViewById(R.id.nameTextView_registerProduct);
        marca = findViewById(R.id.tradeMarkTextView_registerProduct);
        precio = findViewById(R.id.priceTextView_registerProduct);
        tipo = (Spinner) findViewById(R.id.typeSpinner_registerProduct);
        cantidad = findViewById(R.id.amountTextView_registerProduct);
        descripcion = findViewById(R.id.descriptionTextView_registerProduct);

        //Codigo para poner los items en el spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.TypeProductItems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo.setAdapter(adapter);
        controller = new RegistrarProductoController();
    }

    public void registrarProducto(View view){
        String nombreText = nombre.getText().toString();
        String marcaText = marca.getText().toString();
        String precioText = precio.getText().toString();
        String tipoText = tipo.getSelectedItem().toString();
        String cantidadText = cantidad.getText().toString();
        String descripcionText = descripcion.getText().toString();
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