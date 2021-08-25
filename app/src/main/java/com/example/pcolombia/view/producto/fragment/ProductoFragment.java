package com.example.pcolombia.view.producto.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pcolombia.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductoFragment extends Fragment {

    private String nombre;
    private String marca;
    private String precio;
    private String estado;
    private String visibilidad;
    private View rootView;
    private TextView nombreEditText;
    private TextView marcaEditText;
    private TextView precioEditText;
    private TextView estadoEditText;
    private TextView visibilidadEditText;

    public ProductoFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ProductoFragment newInstance(String nombre, String marca, String precio,
                                               String estado, String visibilidad) {
        ProductoFragment fragment = new ProductoFragment();
        fragment.setNombre(nombre);
        fragment.setMarca(marca);
        fragment.setPrecio(precio);
        fragment.setEstado(estado);
        fragment.setVisibilidad(visibilidad);
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
        nombreEditText.setText(nombre);
        marcaEditText.setText(marca);
        precioEditText.setText(precio);
        estadoEditText.setText(estado);
        visibilidadEditText.setText(visibilidad);
        return rootView;
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
}