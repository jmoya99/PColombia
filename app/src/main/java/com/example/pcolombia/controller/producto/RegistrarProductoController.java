package com.example.pcolombia.controller.producto;

import com.example.pcolombia.view.producto.RegistrarProductoActivity;

public class RegistrarProductoController {

    public void registrarProducto(RegistrarProductoActivity activity, String nombre, String marca,
                                  String precio, String tipo, String cantidad, String descripcion) {
        if(nombre == null || nombre.compareTo("")==0){
            activity.campoFaltante();
            return;
        }
        if(marca == null || marca.compareTo("") == 0){
            activity.campoFaltante();
            return;
        }
        if(precio == null || precio.compareTo("")==0){
            activity.campoFaltante();
            return;
        }
        if(tipo == null || tipo.compareTo("") == 0){
            activity.campoFaltante();
            return;
        }
        if(cantidad == null || cantidad.compareTo("")==0){
            activity.campoFaltante();
            return;
        }
        if(descripcion == null || descripcion.compareTo("") == 0){
            activity.campoFaltante();
            return;
        }
    }
}
