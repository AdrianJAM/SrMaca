package com.srmaca.model.ecommerce;

import java.math.BigDecimal;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.srmaca.model.ecommerce.data.AddTextData;
import com.srmaca.model.ecommerce.data.Comparation;
import com.srmaca.model.ecommerce.data.Ingredients;
import com.srmaca.model.ecommerce.data.PillsData;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

/* @JsonPropertyOrder(
    {
        "idProduct",
        "imagebg",
        "title",
        "transitionname",
        "bgstart",
        "textcolor",
        "detailstitle",
        "description",
        "pillsData",
        "whatis",
        "howworks",
        "howuse",
        "benefitsList"
    }
) */

@Entity
@Table(name = "products", schema = "ecommerce")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long  idProduct;

    @Column(name = "name", nullable = true)
    private String name;

    // Atributos Data.JS
    
    @Column(name = "imagebg", nullable = true)
    private String imagebg;

    @Column(name = "title", nullable = true)
    private String title;

    @Column(name = "transitionname", nullable = true)
    private String transitionname;

    @Column(name = "bgstart", nullable = true)
    private String bgstart;

    @Column(name = "textcolor", nullable = true)
    private String textcolor;

    @Column(name = "detailstitle", nullable = true)
    private String detailstitle;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "whatis", nullable = true)
    private String whatis;

    @Column(name = "howworks", nullable = true)
    private String howworks;

    @Column(name = "howuse", nullable = true)
    private String howuse;

    @Column(name = "price", nullable = true)
    private BigDecimal price;

    // Atributos JSON
    @Column(name = "pillsData", columnDefinition = "text", nullable = true)
    private String pillsData;

    @Column(name = "addTextData", columnDefinition = "text", nullable = true)
    private String addTextData;

    @Column(name = "comparation", columnDefinition = "text", nullable = true)
    private String comparation;

    @Column(name = "ingredients", columnDefinition = "text", nullable = true)
    private String ingredients;

    // Get Atributos Como JSON
    @Transient
    public PillsData getPillsData() {
        ObjectMapper objectMapper = new ObjectMapper();
        if (pillsData == null) {
            return null;
        }
        try {
            return objectMapper.readValue(pillsData, PillsData.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Transient
    public AddTextData getAddTextData() {
        ObjectMapper objectMapper = new ObjectMapper();
        if (addTextData == null) {
            return null;
        }
        try {
            return objectMapper.readValue(addTextData, AddTextData.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Transient
    public Comparation getComparation(){
        ObjectMapper objectMapper = new ObjectMapper();
        if(comparation == null){
            return null;
        }
        try {
            return objectMapper.readValue(comparation, Comparation.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Transient
    public Ingredients getIngredients() {
        ObjectMapper objectMapper = new ObjectMapper();
        if (ingredients == null) {
            return null;
        }
        try {
            return objectMapper.readValue(ingredients, Ingredients.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}