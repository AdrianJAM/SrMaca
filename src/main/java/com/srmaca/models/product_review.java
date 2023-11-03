package com.srmaca.models;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "products_reviews")
public class product_review {
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

    //CONSTRUCTOR
    public product_review(){}
    public product_review(Long id_review, Long user_id, Long product_id, short rating, String review_text, Timestamp review_date, Timestamp created_at, Timestamp updated_at){
        this.id_review = id_review;
    }
}
