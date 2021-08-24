package com.example.pcolombia.controller.usuario;

import com.example.pcolombia.MainActivity;
import com.example.pcolombia.model.LocalStorage;
import com.example.pcolombia.model.dao.UserRoomDao;
import com.example.pcolombia.model.pojo.User;

public class ValidarUsuarioController {

    private UserRoomDao userRoomDao;

    public void validarUsuario(MainActivity activity, String correo, String contraseña){
        if(correo == null || correo.compareTo("")==0){
            activity.campoFaltante();
            return;
        }
        if(contraseña == null || contraseña.compareTo("") == 0){
            activity.campoFaltante();
            return;
        }
        this.userRoomDao = LocalStorage.getLocalStorage(
                activity.getApplicationContext()).userRoomDao();
        User user = this.userRoomDao.signIn(correo,contraseña);
        if(user == null){
            activity.correoOContraseñaIncorrectos();
            return;
        }
        if(user.getRol() == "Vendedor"){
            //Pasar a myProducts
        }else{
            //Mostrar mensaje de "El rol es Cliente"
        }
    }
}
