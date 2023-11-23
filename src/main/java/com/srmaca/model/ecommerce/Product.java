package com.srmaca.model.ecommerce;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "products", schema = "ecommerce")
public class Product {
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

    @Column(name = "benefits")
    @JsonIgnore
    private String benefits;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "pilsData", columnDefinition = "jsonb")
    @JsonIgnore
    private String pilsData;

    @Transient
    public List<String> getBenefitsList() {
        return Arrays.asList(benefits.split(","));
    }

    public PillsData getPillsData() throws JsonProcessingException{
        return PillsData.fromJson(this.pilsData);
    }

    public void setPillsData(PillsData pillsData) throws JsonProcessingException{
        this.pilsData = pillsData.toJson();
    }
}