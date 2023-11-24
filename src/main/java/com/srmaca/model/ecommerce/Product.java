package com.srmaca.model.ecommerce;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.srmaca.model.ecommerce.data.AddTextData;
import com.srmaca.model.ecommerce.data.Comparation;
import com.srmaca.model.ecommerce.data.Ingredients;
import com.srmaca.model.ecommerce.data.PillsData;

@Data
@NoArgsConstructor
@AllArgsConstructor

@JsonPropertyOrder(
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
)

@Entity
@Table(name = "products", schema = "ecommerce")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long  idProduct;

    @Column(name = "name")
    @JsonIgnore
    private String name;

    @Column(name = "price")
    @JsonIgnore
    private BigDecimal price;

    @Column(name = "image", nullable = true)
    @JsonIgnore
    private String image;

    @Column(name = "benefits")
    @JsonIgnore
    private String benefits = "";

    @Column(name = "category_id")
    @JsonIgnore
    private Long categoryId;

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

    @Column(name = "pillsData", columnDefinition = "jsonb", nullable = true)
    @JsonIgnore
    private String pillsData;
        
    @Column(name = "addTextData", columnDefinition = "jsonb", nullable = true)
    @JsonIgnore
    private String addTextData;

    @Column(name = "whatis", nullable = true)
    private String whatis;

    @Column(name = "howworks", nullable = true)
    private String howworks;

    @Column(name = "ingredients", columnDefinition = "jsonb", nullable = true)
    @JsonIgnore
    private String ingredients;

    @Column(name = "comparation", columnDefinition = "jsonb", nullable = true)
    @JsonIgnore
    private String comparation;

    @Column(name = "howuse", nullable = true)
    private String howuse;

    @Transient
    public List<String> getBenefitsList() {
        return Arrays.asList(benefits.split(","));
    }

    public PillsData getPillsData(){
        try{
        return PillsData.fromJson(this.pillsData);
        } catch (JsonProcessingException e){
            e.printStackTrace();
            return null;
        }
    }

    public void setPillsData(PillsData pillsData){
        try {
            this.pillsData = pillsData.toJson();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public AddTextData getAddTextData(){
        try {
            return AddTextData.fromJson(this.addTextData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setAddTextData(AddTextData addTextData){
        try {
            this.addTextData = addTextData.toJson();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public Ingredients getIngredients(){
        try {
            return Ingredients.fromJson(this.ingredients);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setIngredients(Ingredients ingredients){
        try {
            this.ingredients = ingredients.toJson();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public Comparation getComparation(){
        try {
            return Comparation.fromJson(this.comparation);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setComparation(Comparation comparation){
        try {
            this.comparation = comparation.toJson();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}