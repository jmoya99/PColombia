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
import com.example.pcolombia.controller.product.EditarProductoController;

import static com.example.pcolombia.R.color.orange;

public class EditarProductoActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText marca;
    private EditText precio;
    private Spinner tipo;
    private EditText cantidad;
    private EditText descripcion;
    private EditarProductoController controller;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(
                Color.parseColor(getString(orange))));
        getSupportActionBar().setTitle(getString(R.string.title_editProduct));
        nombre = findViewById(R.id.nameTextView_editProduct);
        marca = findViewById(R.id.tradeMarkTextView_editProduct);
        precio = findViewById(R.id.priceTextView_editProduct);
        tipo = (Spinner) findViewById(R.id.typeSpinner_editProduct);
        cantidad = findViewById(R.id.amountTextView_editProduct);
        descripcion = findViewById(R.id.descriptionTextView_editProduct);

        //Codigo para poner los items en el spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.TypeProductItems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo.setAdapter(adapter);

        controller = new EditarProductoController();
    }

    public void editarProducto(View view){
        String nombreText = nombre.getText().toString();
        String marcaText = marca.getText().toString();
        String precioText = precio.getText().toString();
        String tipoText = tipo.getSelectedItem().toString();
        String cantidadText = cantidad.getText().toString();
        String descripcionText = descripcion.getText().toString();
        controller.editarProducto(this, nombreText,marcaText,precioText,
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