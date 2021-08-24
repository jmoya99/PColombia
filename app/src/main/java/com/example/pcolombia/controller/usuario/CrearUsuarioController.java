package com.example.pcolombia.controller.usuario;

import com.example.pcolombia.view.usuario.CrearUsuarioActivity;

public class CrearUsuarioController {

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
        // Guardarlo
    }

}
