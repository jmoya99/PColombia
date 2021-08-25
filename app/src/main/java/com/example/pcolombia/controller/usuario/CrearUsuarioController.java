package com.example.pcolombia.controller.usuario;

import com.example.pcolombia.model.LocalStorage;
import com.example.pcolombia.model.dao.UsuarioRoomDao;
import com.example.pcolombia.model.pojo.Usuario;
import com.example.pcolombia.view.usuario.CrearUsuarioActivity;

public class CrearUsuarioController {

    private UsuarioRoomDao usuarioRoomDao;

    public void crearUsuario(CrearUsuarioActivity activity, String nombre, String correo,
                             String contraseña, String rol){
        if(nombre == null || nombre.compareTo("")==0){
            activity.campoFaltante();
            return;
        }
        if(correo == null || correo.compareTo("") == 0){
            activity.campoFaltante();
            return;
        }
        if(contraseña == null || contraseña.compareTo("")== 0){
            activity.campoFaltante();
            return;
        }
        if(rol == null || rol.compareTo("")== 0){
            activity.campoFaltante();
            return;
        }
        this.usuarioRoomDao = LocalStorage.getLocalStorage(
                activity.getApplicationContext()).usuarioRoomDao();
        Usuario usuarioConsulta = this.usuarioRoomDao.obtenerUsuario(correo);
        if(usuarioConsulta != null){
            activity.correoDuplicado();
            return;
        }
        Usuario usuario = new Usuario(correo,nombre,contraseña,rol);
        this.usuarioRoomDao.insertarUsuario(usuario);
        activity.irAValidarUsuario();
    }

}
