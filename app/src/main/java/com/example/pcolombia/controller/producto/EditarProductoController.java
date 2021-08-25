package com.example.pcolombia.controller.producto;

import com.example.pcolombia.model.LocalStorage;
import com.example.pcolombia.model.dao.ProductoRoomDao;
import com.example.pcolombia.model.pojo.Producto;
import com.example.pcolombia.view.producto.EditarProductoActivity;

public class EditarProductoController {

    private ProductoRoomDao productoRoomDao;

    public void editarProducto(EditarProductoActivity activity, String  nombre, String marca, String precio,
                               String tipo, String cantidad, String descripcion, String id, String correo){
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
        int idInt =  Integer.parseInt(id);
        Producto producto = this.productoRoomDao.obtenerProducto(idInt);
        producto.setNombre(nombre);
        producto.setMarca(marca);
        producto.setPrecio(Integer.parseInt(precio));
        producto.setTipo(tipo);
        producto.setCantidad(Integer.parseInt(cantidad));
        producto.setDescripcion(descripcion);
        this.productoRoomDao.modificarProducto(producto);
        return;
    }
}
