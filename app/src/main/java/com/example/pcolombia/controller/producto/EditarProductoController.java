package com.example.pcolombia.controller.producto;

import com.example.pcolombia.model.LocalStorage;
import com.example.pcolombia.model.dao.ProductoRoomDao;
import com.example.pcolombia.model.pojo.Producto;
import com.example.pcolombia.view.producto.EditarProductoActivity;

public class EditarProductoController {

    private ProductoRoomDao productoRoomDao;

    public void cargarProducto(EditarProductoActivity activity,int id){
        this.productoRoomDao = LocalStorage.getLocalStorage(
                activity.getApplicationContext()).productoRoomDao();
        Producto producto = this.productoRoomDao.obtenerProducto(id);
        activity.cargarCampos(producto.getNombre(),producto.getMarca(),""+producto.getPrecio(),producto.getTipo(),
                ""+producto.getCantidad(),producto.getDescripcion());
    }

    public void editarProducto(EditarProductoActivity activity, String  nombre, String marca, String precio,
                               String tipo, String cantidad, String descripcion, int id){
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
        if(Integer.parseInt(cantidad) < 0){
            activity.cantidadNegativa();
            return;
        }
        this.productoRoomDao = LocalStorage.getLocalStorage(
                activity.getApplicationContext()).productoRoomDao();
        Producto producto = this.productoRoomDao.obtenerProducto(id);
        producto.setNombre(nombre);
        producto.setMarca(marca);
        producto.setPrecio(Double.parseDouble(precio));
        producto.setTipo(tipo);
        producto.setCantidad(Integer.parseInt(cantidad));
        producto.setDescripcion(descripcion);
        String estado = "Disponible";
        if(Integer.parseInt(cantidad) == 0){
            estado = "No disponible";
        }
        producto.setEstado(estado);
        this.productoRoomDao.modificarProducto(producto);
        activity.irAGestionarProducto();
    }
}
