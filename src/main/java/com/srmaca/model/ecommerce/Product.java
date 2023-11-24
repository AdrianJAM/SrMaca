package com.srmaca.model.ecommerce;

import com.srmaca.model.ecommerce.data.PillsData;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.databind.ObjectMapper;
// import java.util.Arrays;
// import java.util.List;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
// import com.fasterxml.jackson.core.JsonProcessingException;

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

    // @Column(name = "benefits", nullable = true)
    // private String benefits = "";

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

    @Column(name = "pillsData", columnDefinition = "text", nullable = true)
    private String pillsData;

    @Column(name = "whatis", nullable = true)
    private String whatis;

    @Column(name = "howworks", nullable = true)
    private String howworks;

    @Column(name = "howuse", nullable = true)
    private String howuse;

/*     @Transient
    public List<String> getBenefitsList() {
        return Arrays.asList(benefits.split(","));
    } */

   /*  public PillsData getPillsData(){
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
    } */
}