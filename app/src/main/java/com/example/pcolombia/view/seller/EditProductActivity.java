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
import com.example.pcolombia.controller.product.EditProductController;

import static com.example.pcolombia.R.color.orange;

public class EditProductActivity extends AppCompatActivity {

    private EditText name;
    private EditText tradeMark;
    private EditText price;
    private Spinner type;
    private EditText amount;
    private EditText description;
    private EditProductController controller;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(
                Color.parseColor(getString(orange))));
        getSupportActionBar().setTitle(getString(R.string.title_editProduct));
        name = findViewById(R.id.nameTextView_registerProduct);
        tradeMark = findViewById(R.id.tradeMarkTextView_registerProduct);
        price = findViewById(R.id.priceTextView_registerProduct);
        type = (Spinner) findViewById(R.id.typeSpinner_registerProduct);
        amount = findViewById(R.id.amountTextView_registerProduct);
        description = findViewById(R.id.descriptionTextView_registerProduct);

        //Codigo para poner los items en el spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.TypeProductItems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(adapter);

        controller = new EditProductController();
    }

    public void editProduct(View view){
        String nameText = name.getText().toString();
        String tradeMarkText = tradeMark.getText().toString();
        String priceText = price.getText().toString();
        String typeText = type.getSelectedItem().toString();
        String amountText = amount.getText().toString();
        String descriptionText = description.getText().toString();
        controller.editProduct(this, nameText,tradeMarkText,priceText,
                                   typeText, amountText, descriptionText);
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

}