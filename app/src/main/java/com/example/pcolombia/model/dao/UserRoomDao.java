package com.example.pcolombia.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pcolombia.model.pojo.User;

import java.util.List;

@Dao
public interface UserRoomDao {

    @Query("SELECT * FROM user")
    List<User> getAllUsers();

    @Query("SELECT * FROM user WHERE email = :emailQuery AND password = :passwordQuery")
    User signIn(String emailQuery,String passwordQuery);

    @Query("SELECT * FROM user WHERE email = :emailQuery")
    User getUser(String emailQuery);

    @Insert
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleUser(User user);
}
