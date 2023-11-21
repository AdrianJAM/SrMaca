package com.srmaca.model.ecommerce;

import jakarta.persistence.*;
import java.sql.Timestamp;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "products_reviews", schema = "ecommerce")
public class Product_review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_review")
    private Long id_review;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "rating")
    private short rating;

    @Column(name = "review_text")
    private String review_text;

    @Column(name = "review_date")
    private Timestamp review_date;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;
}
