package com.example.pcolombia.controller.producto;

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
        Producto producto = new Producto(nombre, marca, Double.parseDouble(precio),"Disponible", tipo,
                                        descripcion, Integer.parseInt(cantidad),"Privado",correo);
        return;
    }
}
