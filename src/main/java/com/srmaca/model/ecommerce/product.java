package com.srmaca.model.ecommerce;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
// import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

@Getter
@Setter
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

    @Column(name = "benefits", columnDefinition = "jsonb")
    // private List<String> benefits;
    private JsonNode benefits;

    @Column(name = "category_id")
    private Long categoryId;
}