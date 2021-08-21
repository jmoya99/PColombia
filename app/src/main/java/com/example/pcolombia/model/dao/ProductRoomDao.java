package com.example.pcolombia.model.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pcolombia.model.pojo.Product;

import java.util.List;

public interface ProductRoomDao {

    @Query("SELECT * FROM product")
    List<Product> getAllProducts();

    @Query("SELECT * FROM product WHERE user_email = :emailQuery")
    List<Product> getAllProductsForSeller(String emailQuery);

    @Query("SELECT * FROM product WHERE id = :idQuery")
    Product getProduct(String idQuery);

    @Insert
    void insertproduct(Product product);

    @Update
    void updateproduct(Product product);

    @Delete
    void deleproduct(Product product);

}
