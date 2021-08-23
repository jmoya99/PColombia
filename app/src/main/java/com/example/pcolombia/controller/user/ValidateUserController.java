package com.example.pcolombia.controller.user;

import com.example.pcolombia.MainActivity;
import com.example.pcolombia.model.LocalStorage;
import com.example.pcolombia.model.dao.UserRoomDao;
import com.example.pcolombia.model.pojo.User;

public class ValidateUserController {

    private UserRoomDao userRoomDao;

    public void validateUser(MainActivity activity, String email, String password){
        if(email == null || email.compareTo("")==0){
            activity.fieldMissing();
            return;
        }
        if(password == null || password.compareTo("") == 0){
            activity.fieldMissing();
            return;
        }
        this.userRoomDao = LocalStorage.getLocalStorage(
                activity.getApplicationContext()).userRoomDao();
        User user = this.userRoomDao.signIn(email,password);
        if(user == null){
            activity.incorrectEmailOrPassword();
            return;
        }
        if(user.getRol() == "Vendedor"){
            //Pasar a myProducts
        }else{
            //Mostrar mensaje de "El rol es Cliente"
        }
    }
}
