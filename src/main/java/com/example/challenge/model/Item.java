package com.example.challenge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "item") // Nombre de la tabla en la base de datos
public class Item {

    @Id // Indica que este campo es una clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente el valor para este campo
    @Column(name = "Item_Id") // Nombre de la columna en la base de datos
    private Long itemId;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;

    // Constructor vacío requerido por JPA
    public Item() {
    }

    // Constructor con todos los atributos excepto itemId
    public Item(String description, double price, int quantity) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters y setters para todos los atributos
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
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
}
