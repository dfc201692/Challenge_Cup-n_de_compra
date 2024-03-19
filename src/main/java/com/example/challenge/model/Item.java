package com.example.challenge.model;

public class Item {

    private String itemId;
    private String description;
    private double price;
    private int quantity;

    // Constructor
    public Item(String itemId, String description, double price, int quantity) {
        this.itemId = itemId;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // ... (Agrega métodos adicionales si es necesario)

}
