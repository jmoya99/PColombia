package com.example.pcolombia.controller.usuario;

import com.example.pcolombia.view.usuario.CrearUsuarioActivity;
import com.example.pcolombia.view.usuario.EditarUsuarioActivity;

public class EditarUsuarioController {

    public void editarUsuario(EditarUsuarioActivity activity, String nombre, String contraseña){
        if(nombre == null || nombre.compareTo("")==0){
            activity.campoFaltante();
            return;
        }
        if(contraseña == null || contraseña.compareTo("")== 0){
            activity.campoFaltante();
            return;
        }
        //Editar
    }
}
