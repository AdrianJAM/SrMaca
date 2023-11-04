package com.srmaca.models.ecommerce;

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
        this.user_id = user_id;
        this.product_id = product_id;
        this.rating = rating;
        this.review_text = review_text;
        this.review_date = review_date;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
    //GETTERS AND SETTERS
    //ID_REVIEW
    public Long getIdReview(){
        return id_review;
    }
    public void setIdReview(Long id_review){
        this.id_review = id_review;
    }
    //USER_ID
    public Long getUserId(){
        return user_id;
    }
    public void setUserId(Long user_id){
        this.user_id = user_id;
    }
    //PRODUCT_ID
    public Long getProductId(){
        return product_id;
    }
    public void setProductId(Long product_id){
        this.product_id = product_id;
    }
    //RATING
    public short getRating(){
        return rating;
    }
    public void setRating(short rating){
        this.rating = rating;
    }
    //REVIEW_TEXT
    public String getReviewText(){
        return review_text;
    }
    public void setReviewText(String review_text){
        this.review_text = review_text;
    }
    //REVIEW_DATE
    public Timestamp getReviewDate(){
        return review_date;
    }
    public void setReviewDate(Timestamp review_date){
        this.review_date = review_date;
    }
    //CREATED_AT
    public Timestamp getCreateAt(){
        return created_at;
    }
    public void setCreatedAt(Timestamp created_at){
        this.created_at = created_at;
    }
    //UPDATED_AT
    public Timestamp getUpdatedAt(){
        return updated_at;
    }
    public void setUpdatedAt(Timestamp updated_at){
        this.updated_at = updated_at;
    }
}
