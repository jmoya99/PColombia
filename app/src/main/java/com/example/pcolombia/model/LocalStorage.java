package com.example.pcolombia.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pcolombia.model.dao.ProductRoomDao;
import com.example.pcolombia.model.dao.UserRoomDao;
import com.example.pcolombia.model.pojo.*;

@Database(entities = {User.class, Product.class},version = 1)
public abstract class LocalStorage extends RoomDatabase {

    public abstract UserRoomDao userRoomDao();
    public abstract ProductRoomDao productRoomDao();

    private static LocalStorage localStorage;

    public static LocalStorage getLocalStorage(final Context context){
        if(localStorage == null){
            localStorage = Room.databaseBuilder(context,
                    LocalStorage.class,
                    "pcolombia")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build();
        }
        return localStorage;
    }

}
