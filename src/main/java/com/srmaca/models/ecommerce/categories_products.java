package com.srmaca.models.ecommerce;

import jakarta.persistence.*;

@Entity
@Table(name = "categories_products")
public class categories_products{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Long id_category;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    //CONSTRUCTOR
    public categories_products(){}
    public categories_products(String name, String description) {
        this.name = name;
        this.description = description;
    }
    //GETTER AND SETTERS
    //ID_CATEGORY
    public Long getIdCategory() {
        return id_category;
    }
    public void setIdCategory(Long id_category) {
        this.id_category = id_category;
    }
    //NAME
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //DESCRIPTION
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
