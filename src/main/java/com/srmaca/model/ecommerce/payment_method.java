package com.srmaca.model.ecommerce;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "payment_methods")
public class payment_method{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment")
    private Long id_payment;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "card_holder_name", length = 255)
    private String card_holder_name;

    @Column(name = "card_number", length = 16)
    private char card_number;

    @Column(name = "expiration_date")
    private Date expiration_date;

    @Column(name = "cvv")
    private String cvv;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;

    //CONSTRUCTOR
    public payment_method(){}
    public payment_method(Long id_payment, Long user_id, String card_holder_name, char card_number, Date expiration_date, String cvv, Timestamp created_at, Timestamp updated_at){
        this.id_payment = id_payment;
        this.user_id = user_id;
        this.card_holder_name = card_holder_name;
        this.card_number = card_number;
        this.expiration_date = expiration_date;
        this.cvv = cvv;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
    //GETTERS AND SETTERS
    //ID_PAYMENT
    public Long getIdPayment(){
        return id_payment;
    }
    public void setIdPayment(Long id_payment){
        this.id_payment = id_payment;
    }
    //USER_ID
    public Long getUserId(){
        return user_id;
    }
    public void setUserId(Long user_id){
        this.user_id = user_id;
    }
    //CARD_HOLDER_NAME
    public String getCardHolderName(){
        return card_holder_name;
    }
    public void setCardHolderName(String card_holder_name){
        this.card_holder_name = card_holder_name;
    }
    //CARD_NUMBER
    public char getCardNumber(){
        return card_number;
    }
    public void setCardNumber(char card_number){
        this.card_number = card_number;
    }
    //EXPIRATION_DATE
    public Date getExpirationDate(){
        return expiration_date;
    }
    public void setExpirationDate(Date expiration_date){
        this.expiration_date = expiration_date;
    }
    //CVV
    public String getCvv(){
        return cvv;
    }
    public void setCvv(String cvv){
        this.cvv = cvv;
    }
    //CREATED_AT
    public Timestamp getCreatedAt(){
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
