package com.example.pcolombia.controller.producto;

import com.example.pcolombia.R;
import com.example.pcolombia.model.LocalStorage;
import com.example.pcolombia.model.dao.ProductoRoomDao;
import com.example.pcolombia.model.pojo.Producto;
import com.example.pcolombia.view.producto.GestionarProductoActivity;

public class GestionarProductoController {

    private ProductoRoomDao productoRoomDao;

    public void eliminarProducto(GestionarProductoActivity activity, int id){
        this.productoRoomDao = LocalStorage.getLocalStorage(
                activity.getApplicationContext()).productoRoomDao();
        Producto producto = this.productoRoomDao.obtenerProducto(id);
        this.productoRoomDao.eliminarProducto(producto);
        activity.irAMisProductos();
    }

    public void cargarProducto(GestionarProductoActivity activity, int id){
        this.productoRoomDao = LocalStorage.getLocalStorage(
                activity.getApplicationContext()).productoRoomDao();
        Producto producto = this.productoRoomDao.obtenerProducto(id);
        String pubicarButton = activity.getString(R.string.publicarProductoButton_gestionarProducto);
        if(producto.getVisibilidad().equals("Publico")){
            pubicarButton = activity.getString(R.string.ocultarProductoButton_gestionarProducto);
        }
        activity.cargarCampos(producto.getNombre(), producto.getMarca(),
                String.valueOf(producto.getPrecio()), producto.getTipo(), producto.getEstado(),
                producto.getVisibilidad(), producto.getDescripcion(), String.valueOf(producto.getCantidad()),
                pubicarButton);
    }

    public void publicarOcultarProducto(GestionarProductoActivity activity, int id){
        this.productoRoomDao = LocalStorage.getLocalStorage(
                activity.getApplicationContext()).productoRoomDao();
        Producto producto = this.productoRoomDao.obtenerProducto(id);
        String visibilidad = "Publico";
        if(producto.getVisibilidad().equals("Publico")){
            visibilidad = "Privado";
        }
        producto.setVisibilidad(visibilidad);
        this.productoRoomDao.modificarProducto(producto);
        activity.irAMisProductos();
    }

}
