package com.srmaca.model.ecommerce;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "categories_products", schema="ecommerce")
public class Categories_products{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Long id_category;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;
}
