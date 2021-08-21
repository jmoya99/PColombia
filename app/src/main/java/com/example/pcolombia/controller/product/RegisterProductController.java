package com.example.pcolombia.controller.product;

import com.example.pcolombia.view.seller.RegisterProductActivity;

public class RegisterProductController {
    public void registerProduct(RegisterProductActivity activity, String name, String tradeMark,
                                String price, String type, String amount, String description) {
        if(name == null || name.compareTo("")==0){
            activity.fieldMissing();
            return;
        }
        if(tradeMark == null || tradeMark.compareTo("") == 0){
            activity.fieldMissing();
            return;
        }
        if(price == null || price.compareTo("")==0){
            activity.fieldMissing();
            return;
        }
        if(type == null || type.compareTo("") == 0){
            activity.fieldMissing();
            return;
        }
        if(amount == null || amount.compareTo("")==0){
            activity.fieldMissing();
            return;
        }
        if(description == null || description.compareTo("") == 0){
            activity.fieldMissing();
            return;
        }
    }
}
