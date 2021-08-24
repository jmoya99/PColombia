package com.example.pcolombia.controller.product;

import com.example.pcolombia.view.seller.EditarProductoActivity;

public class EditarProductoController {

    public void editarProducto(EditarProductoActivity activity, String  nombre, String marca, String precio,
                               String tipo, String cantidad, String descripcion){
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
