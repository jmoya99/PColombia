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
    private int ID;
    private String correoVendedor;

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

        String correo = getIntent().getExtras().getString("correo_usuario");
        correo = correo != null ? correo : "";
        setCorreoVendedor(correo);

        int id = getIntent().getExtras().getInt("id");
        setID(id);

        controller = new EditarProductoController();
        controller.cargarProducto(this,getID());
    }

    public void editarProducto(View view){
        String nombreText = nombreEditText.getText().toString();
        String marcaText = marcaEditText.getText().toString();
        String precioText = precioEditText.getText().toString();
        String tipoText = tipoSpinner.getSelectedItem().toString();
        String cantidadText = cantidadEditText.getText().toString();
        String descripcionText = descripcionEditText.getText().toString();
        System.out.println("**********************"+tipoText);
        controller.editarProducto(this, nombreText,marcaText,precioText, tipoText,
                                    cantidadText, descripcionText, getID(), getCorreoVendedor());
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
        tipoSpinner.setSelection(((ArrayAdapter)tipoSpinner.getAdapter()).getPosition(tipo));
        cantidadEditText.setText(cantidad);
        descripcionEditText.setText(descripcion);
    }

    public void cancelar(View view){
        irAGestionarProducto();
    }

    public void irAGestionarProducto(){
        Intent intent = new Intent(this,GestionarProductoActivity.class);
        intent.putExtra("correo_usuario",getCorreoVendedor());
        intent.putExtra("id", getID());
        startActivity(intent);
        finish();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCorreoVendedor() {
        return correoVendedor;
    }

    public void setCorreoVendedor(String correoVendedor) {
        this.correoVendedor = correoVendedor;
    }
}