package com.example.pcolombia.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pcolombia.model.pojo.Usuario;

import java.util.List;

@Dao
public interface UsuarioRoomDao {

    @Query("SELECT * FROM usuario")
    List<Usuario> obtenerUsuarios();

    @Query("SELECT * FROM usuario WHERE correo = :correo AND contrasena = :contrasena")
    Usuario validarUsuario(String correo, String contrasena);

    @Query("SELECT * FROM usuario WHERE correo = :correo")
    Usuario obtenerUsuario(String correo);

    @Insert
    void insertarUsuario(Usuario usuario);

    @Update
    void modificarUsuario(Usuario usuario);

    @Delete
    void eliminarUsuario(Usuario usuario);
}
