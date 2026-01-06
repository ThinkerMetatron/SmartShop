package com.example.SmartShop;

import jakarta.persistence.*;

@Entity
@Table(name = "smartphones") // Назва таблиці в PostgreSQL
public class Smartphone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private Integer price;
    private String img; // Тут будемо зберігати емодзі або посилання на фото

    // Порожній конструктор (обов'язковий для JPA)
    public Smartphone() {}

    // Конструктор для зручності
    public Smartphone(String name, String brand, Integer price, String img) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.img = img;
    }

    // Геттери та Сеттери (Eclipse може згенерувати їх автоматично: Source -> Generate Getters and Setters)
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public Integer getPrice() { return price; }
    public void setPrice(Integer price) { this.price = price; }
    public String getImg() { return img; }
    public void setImg(String img) { this.img = img; }
}