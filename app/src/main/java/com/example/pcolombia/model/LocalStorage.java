package com.example.pcolombia.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pcolombia.model.dao.ProductoRoomDao;
import com.example.pcolombia.model.dao.UsuarioRoomDao;
import com.example.pcolombia.model.pojo.*;

@Database(entities = {Usuario.class, Producto.class},version = 1)
public abstract class LocalStorage extends RoomDatabase {

    public abstract UsuarioRoomDao usuarioRoomDao();
    public abstract ProductoRoomDao productoRoomDao();

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
