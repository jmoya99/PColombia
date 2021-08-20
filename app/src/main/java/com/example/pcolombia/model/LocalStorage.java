package com.example.pcolombia.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pcolombia.model.pojo.*;

@Database(entities = {user.class,product.class},version = 1)
public abstract class LocalStorage extends RoomDatabase {

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
