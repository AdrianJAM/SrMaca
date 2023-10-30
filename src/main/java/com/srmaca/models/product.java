package com.srmaca.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "products")
public class product {
    // Columnas de Tabla Productos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long  idProduct;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "category_id")
    private Long categoryId;

    // Constructor Clase Product

    public product(){
    }

    public product(String name, String description, String image, Long categoryId){
        this.name = name;
        this.description = description;
        this.image = image;
        this.categoryId = categoryId;
    }

    //Getters AND Setters
    //ID_PRODUCT
    public Long getId(){
        return idProduct;
    }
    public void setId(Long id){
        this.idProduct = id;
    }
    //NAME
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    //DESCRIPTION
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.name = description;
    }
    //IMAGE
    public String getImage(){
        return image;
    }
    public void setImage(String image){
        this.image = image;
    }
    //NAME
    public Long getCategoryId(){
        return categoryId;
    }
    public void setName(Long category_id){
        this.categoryId = category_id;
    }
}