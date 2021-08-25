package com.example.pcolombia.controller.usuario;

import com.example.pcolombia.model.LocalStorage;
import com.example.pcolombia.model.dao.UsuarioRoomDao;
import com.example.pcolombia.model.pojo.Usuario;
import com.example.pcolombia.view.usuario.CrearUsuarioActivity;
import com.example.pcolombia.view.usuario.EditarUsuarioActivity;

public class EditarUsuarioController {

    private UsuarioRoomDao usuarioRoomDao;

    public void editarUsuario(EditarUsuarioActivity activity, String nombre, String contraseña, String correo){
        if(nombre == null || nombre.compareTo("")==0){
            activity.campoFaltante();
            return;
        }
        if(contraseña == null || contraseña.compareTo("")== 0){
            activity.campoFaltante();
            return;
        }
        this.usuarioRoomDao = LocalStorage.getLocalStorage(
                activity.getApplicationContext()).usuarioRoomDao();
        Usuario usuario = this.usuarioRoomDao.obtenerUsuario(correo);
        usuario.setNombre(nombre);
        usuario.setContrasena(contraseña);
        this.usuarioRoomDao.modificarUsuario(usuario);
        activity.irAGestionarUsuario();
    }

    public void cargarDatos(EditarUsuarioActivity activity, String correo){
        this.usuarioRoomDao = LocalStorage.getLocalStorage(
                activity.getApplicationContext()).usuarioRoomDao();
        Usuario usuario = this.usuarioRoomDao.obtenerUsuario(correo);
        activity.cargarCampos(usuario.getNombre(),usuario.getContrasena());
    }
}
