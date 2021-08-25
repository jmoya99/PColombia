package com.example.pcolombia.controller.usuario;

import com.example.pcolombia.model.LocalStorage;
import com.example.pcolombia.model.dao.UsuarioRoomDao;
import com.example.pcolombia.model.pojo.Usuario;
import com.example.pcolombia.view.usuario.GestionarUsuarioActivity;

public class GestionarUsuarioController {

    private UsuarioRoomDao usuarioRoomDao;

    public void eliminarUsuario(GestionarUsuarioActivity activity, String correo){

        this.usuarioRoomDao = LocalStorage.getLocalStorage(
                activity.getApplicationContext()).usuarioRoomDao();
        Usuario usuario = this.usuarioRoomDao.obtenerUsuario(correo);
        this.usuarioRoomDao.eliminarUsuario(usuario);
        activity.irAValidarUSuario();
    }

    public void cargarUsuario(GestionarUsuarioActivity activity, String correo){
        this.usuarioRoomDao = LocalStorage.getLocalStorage(
                activity.getApplicationContext()).usuarioRoomDao();
        Usuario usuario = this.usuarioRoomDao.obtenerUsuario(correo);
        String contrasena = "";
        for(int i = 0;i < usuario.getContrasena().length();i++){
            contrasena += "*";
        }
        activity.cargarCampos(usuario.getNombre(),usuario.getCorreo(),contrasena,usuario.getRol());
    }

}
