package com.example.pcolombia.controller.usuario;

import com.example.pcolombia.MainActivity;
import com.example.pcolombia.model.LocalStorage;
import com.example.pcolombia.model.dao.UsuarioRoomDao;
import com.example.pcolombia.model.pojo.Usuario;

public class ValidarUsuarioController {

    private UsuarioRoomDao usuarioRoomDao;

    public void validarUsuario(MainActivity activity, String correo, String contraseña){
        if(correo == null || correo.compareTo("")==0){
            activity.campoFaltante();
            return;
        }
        if(contraseña == null || contraseña.compareTo("") == 0){
            activity.campoFaltante();
            return;
        }
        this.usuarioRoomDao = LocalStorage.getLocalStorage(
                activity.getApplicationContext()).usuarioRoomDao();
        Usuario usuario = this.usuarioRoomDao.validarUsuario(correo,contraseña);
        if(usuario == null){
            activity.correoOContraseñaIncorrectos();
            return;
        }
        if(usuario.getRol() == "Vendedor"){
            //Pasar a myProducts
        }else{
            //Mostrar mensaje de "El rol es Cliente"
        }
    }
}
