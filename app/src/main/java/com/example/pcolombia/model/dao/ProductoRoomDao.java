package com.example.pcolombia.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pcolombia.model.pojo.Producto;

import java.util.List;

@Dao
public interface ProductoRoomDao {

    @Query("SELECT * FROM producto")
    List<Producto> obtenerProductos();

    @Query("SELECT * FROM producto WHERE usuario_correo = :correo")
    List<Producto> obtenerProductosPorVendedor(String correo);

    @Query("SELECT * FROM producto WHERE id = :id")
    Producto obtenerProducto(int id);

    @Insert
    void insertarProducto(Producto producto);

    @Update
    void modificarProducto(Producto producto);

    @Delete
    void eliminarProducto(Producto producto);

}
