package com.example.pcolombia.view.producto.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.pcolombia.R;
import com.example.pcolombia.view.producto.GestionarProductoActivity;
import com.example.pcolombia.view.producto.MisProductosActivity;
import com.example.pcolombia.view.usuario.GestionarUsuarioActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductoFragment extends Fragment {

    private int id;
    private String nombre;
    private String marca;
    private String precio;
    private String estado;
    private String visibilidad;
    private MisProductosActivity misProductosActivity;
    private View rootView;
    private TextView nombreEditText;
    private TextView marcaEditText;
    private TextView precioEditText;
    private TextView estadoEditText;
    private TextView visibilidadEditText;
    private Button gestionarProductoButton;

    public ProductoFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ProductoFragment newInstance(int id, String nombre, String marca, String precio,
                                               String estado, String visibilidad,
                                               MisProductosActivity misProductosActivity) {
        ProductoFragment fragment = new ProductoFragment();
        fragment.setID(id);
        fragment.setNombre(nombre);
        fragment.setMarca(marca);
        fragment.setPrecio(precio);
        fragment.setEstado(estado);
        fragment.setVisibilidad(visibilidad);
        fragment.setMisProductosActivity(misProductosActivity);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_producto,container,false);
        nombreEditText = rootView.findViewById(R.id.nombreTextView_producto);
        marcaEditText = rootView.findViewById(R.id.marcaTextView_producto);
        precioEditText = rootView.findViewById(R.id.precioTextView_producto);
        estadoEditText = rootView.findViewById(R.id.estadoTextView_producto);
        visibilidadEditText = rootView.findViewById(R.id.visibilidadTextView_producto);
        gestionarProductoButton = rootView.findViewById(R.id.gestionarButton_producto);
        nombreEditText.setText(nombre);
        marcaEditText.setText(marca);
        precioEditText.setText(precio);
        estadoEditText.setText(estado);
        visibilidadEditText.setText(visibilidad);
        gestionarProductoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMisProductosActivity().irAGestionarProducto(getID());
            }
        });
        return rootView;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }

    public MisProductosActivity getMisProductosActivity() {
        return misProductosActivity;
    }

    public void setMisProductosActivity(MisProductosActivity misProductosActivity) {
        this.misProductosActivity = misProductosActivity;
    }
}