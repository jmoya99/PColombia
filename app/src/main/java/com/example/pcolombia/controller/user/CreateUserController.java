package com.example.pcolombia.controller.user;

import com.example.pcolombia.view.user.CreateUserActivity;

public class CreateUserController {

    public void createUser(CreateUserActivity activity, String name,String email, String password){
        if(name == null || name.compareTo("")==0){
            activity.missingField();
            return;
        }
        if(email == null || email.compareTo("") == 0){
            activity.missingField();
            return;
        }
        if(password == null || password.compareTo("")== 0){
            activity.missingField();
            return;
        }
        // SAVE it
    }

}
