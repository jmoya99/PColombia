package com.example.pcolombia.controller.producto;

import com.example.pcolombia.model.LocalStorage;
import com.example.pcolombia.model.dao.ProductoRoomDao;
import com.example.pcolombia.model.pojo.Producto;
import com.example.pcolombia.view.producto.MisProductosActivity;

import java.util.List;

public class MisProductosController {

    private ProductoRoomDao productoRoomDao;

    public void cargarProductos(MisProductosActivity activity){
        this.productoRoomDao = LocalStorage.getLocalStorage(
                activity.getApplicationContext()).productoRoomDao();
        List<Producto> productos = this.productoRoomDao.obtenerProductosPorVendedor(
                activity.getCorreoVendedor());
        for (Producto producto: productos) {
            activity.agregarProducto(producto.getId(),producto.getNombre(),producto.getMarca(),
                    Double.toString(producto.getPrecio()),producto.getEstado(),
                    producto.getVisibilidad());
        }
    }

}
