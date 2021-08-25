package com.example.pcolombia.controller.producto;

import android.content.Intent;

import com.example.pcolombia.model.LocalStorage;
import com.example.pcolombia.model.dao.ProductoRoomDao;
import com.example.pcolombia.model.pojo.Producto;
import com.example.pcolombia.view.producto.RegistrarProductoActivity;

public class RegistrarProductoController {

    private ProductoRoomDao productoRoomDao;
    public void registrarProducto(RegistrarProductoActivity activity, String nombre, String marca,
                                  String precio, String tipo, String cantidad, String descripcion,
                                  String correo) {
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
        this.productoRoomDao = LocalStorage.getLocalStorage(
                activity.getApplicationContext()).productoRoomDao();
        String estado = "Disponible";
        if(Integer.parseInt(cantidad) == 0){
            estado = "No disponible";
        }
        Producto producto = new Producto(nombre, marca, Double.parseDouble(precio),estado, tipo,
                                        descripcion, Integer.parseInt(cantidad),"Privado",correo);
        this.productoRoomDao.insertarProducto(producto);
        activity.irAMisProductos();
    }
}
