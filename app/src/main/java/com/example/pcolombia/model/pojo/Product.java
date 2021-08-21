package com.example.pcolombia.model.pojo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "product", foreignKeys =
        {@ForeignKey(entity = User.class,
                parentColumns = "email",
                childColumns = "user_email",
                onDelete = ForeignKey.CASCADE)})
public class Product {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    @ColumnInfo(name = "trademark")
    private String trademark;

    @NonNull
    @ColumnInfo(name = "price")
    private double price;

    @NonNull
    @ColumnInfo(name = "state")
    private String state;

    @NonNull
    @ColumnInfo(name = "type")
    private String type;

    @NonNull
    @ColumnInfo(name = "description")
    private String description;

    @NonNull
    @ColumnInfo(name = "amount")
    private int amount;

    @NonNull
    @ColumnInfo(name = "visibility")
    private String visibility;

    @NonNull
    @ColumnInfo(name = "user_email")
    private String user_email;

    public Product(String name, String trademark, double price, String state, String type,
                   String description, int amount, String visibility, String user_email) {
        this.name = name;
        this.trademark = trademark;
        this.price = price;
        this.state = state;
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.visibility = visibility;
        this.user_email = user_email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getUserEmail() {
        return user_email;
    }

    public void setUserEmail(String user_email) {
        this.user_email = user_email;
    }
}
