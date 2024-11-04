package com.example.restapidemoo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //memberi tahu JPA bahwa kelas ini adalah entitas yang akan dipetakan ke tabel dalam database
public class Product {
    @Id // Menandakan bahwa id adalah primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Menetapkan strategi untuk menghasilkan nilai ID secara otomatis
    private Long id;
    private String name;
    private double price;

    private String description;

    public Product() {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(Long id, String name, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }
    public Product(Long id, String name, String description, double price) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.price = price;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}

