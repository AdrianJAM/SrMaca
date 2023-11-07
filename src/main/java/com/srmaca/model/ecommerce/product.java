package com.srmaca.model.ecommerce;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "products")
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long  idProduct;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "image")
    private String image;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "user_id")
    private Long user_id;

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
    public Long getIdProduct(){
        return idProduct;
    }
    public void setIdProduct(Long id){
        this.idProduct = id;
    }
    //NAME
    public String getNameProduct(){
        return name;
    }
    public void setNameProduct(String name){
        this.name = name;
    }
    //DESCRIPTION
    public String getDescriptionProduct(){
        return description;
    }
    public void setDescriptionProduct(String description){
        this.name = description;
    }
    //PRICE
    public BigDecimal getPriceProduct(){
        return price;
    }
    public void setPriceProduct(BigDecimal price){
        this.price = price;
    }
    //IMAGE
    public String getImageProduct(){
        return image;
    }
    public void setImageProduct(String image){
        this.image = image;
    }
    //CATEGORY_ID ONLY GET
    public Long getCategoryId(){
        return categoryId;
    }
    public void setCategoryId(Long categoryId){
        this.categoryId = categoryId;
    }
}