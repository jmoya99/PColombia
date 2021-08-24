package com.example.pcolombia.view.seller.fragment;

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
    private TextView nombreTextView;
    private TextView marcaTextView;
    private TextView precioTextView;
    private TextView estadoTextView;
    private TextView visibilidadTextView;

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
        rootView = inflater.inflate(R.layout.fragment_product,container,false);
        nombreTextView = rootView.findViewById(R.id.nameTextView_productFragment);
        marcaTextView = rootView.findViewById(R.id.tradeMarkTextView_productFragment);
        precioTextView = rootView.findViewById(R.id.priceTextView_productFragment);
        estadoTextView = rootView.findViewById(R.id.stateTextView_productFragment);
        visibilidadTextView = rootView.findViewById(R.id.visibilityTextView_productFragment);
        nombreTextView.setText(nombre);
        marcaTextView.setText(marca);
        precioTextView.setText(precio);
        estadoTextView.setText(estado);
        visibilidadTextView.setText(visibilidad);
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