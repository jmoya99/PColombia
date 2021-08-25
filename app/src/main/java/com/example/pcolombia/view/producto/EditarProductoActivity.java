package com.example.pcolombia.view.producto;

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

import com.example.pcolombia.R;
import com.example.pcolombia.controller.producto.EditarProductoController;

import static com.example.pcolombia.R.color.orange;

public class EditarProductoActivity extends AppCompatActivity {

    private EditText nombreEditText;
    private EditText marcaEditText;
    private EditText precioEditText;
    private Spinner tipoSpinner;
    private EditText cantidadEditText;
    private EditText descripcionEditText;
    private EditarProductoController controller;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_producto);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(
                Color.parseColor(getString(orange))));
        getSupportActionBar().setTitle(getString(R.string.titulo_editarProducto));
        nombreEditText = findViewById(R.id.nombreTextView_editarProducto);
        marcaEditText = findViewById(R.id.marcaTextView_editarProducto);
        precioEditText = findViewById(R.id.precioTextView_editarProducto);
        tipoSpinner = (Spinner) findViewById(R.id.tipoSpinner_editarProducto);
        cantidadEditText = findViewById(R.id.cantidadTextView_editarProducto);
        descripcionEditText = findViewById(R.id.descripcionTextView_editarProducto);

        //Codigo para poner los items en el spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tipoProductoItems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoSpinner.setAdapter(adapter);

        controller = new EditarProductoController();
    }

    public void editarProducto(View view){
        String nombreText = nombreEditText.getText().toString();
        String marcaText = marcaEditText.getText().toString();
        String precioText = precioEditText.getText().toString();
        String tipoText = tipoSpinner.getSelectedItem().toString();
        String cantidadText = cantidadEditText.getText().toString();
        String descripcionText = descripcionEditText.getText().toString();
        String idText = getIntent().getExtras().getString("id");
        String correoText = getIntent().getExtras().getString("correo-usuario");
        controller.editarProducto(this, nombreText,marcaText,precioText, tipoText,
                                    cantidadText, descripcionText, idText, correoText);
        Intent activity = new Intent(this, GestionarProductoActivity.class);
        activity.putExtra("id",idText);
        activity.putExtra("correo-usuario",correoText);
        startActivity(activity);
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

    public void cargarCampos(String  nombre, String marca, String precio,String tipo,
                             String cantidad, String descripcion){
        nombreEditText.setText(nombre);
        marcaEditText.setText(marca);
        precioEditText.setText(precio);
        tipoSpinner.setSelection(((ArrayAdapter)tipoSpinner.getAdapter()).getPosition("tipo"));
        cantidadEditText.setText(cantidad);
        descripcionEditText.setText(descripcion);
    }

}