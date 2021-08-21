package com.example.pcolombia.controller.user;

import com.example.pcolombia.MainActivity;

public class ValidateUserController {

    public void signIn(MainActivity activity, String email, String password){
        if(email == null || email.compareTo("")==0){
            activity.fieldMissing();
            return;
        }
        if(password == null || password.compareTo("") == 0){
            activity.fieldMissing();
            return;
        }
    }
}
