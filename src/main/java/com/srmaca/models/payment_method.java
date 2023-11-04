package com.srmaca.models;

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
    public payment_method(Long id_payment, Long user_id, String card_holder_name, char card_number, Date expiration_date, String cvv, Timestamp created_at, Timestamp updated){
        this.id_payment = id_payment;
        this.user_id = user_id;
        this.card_holder_name = card_holder_name;
        this.card_number = card_number;
        this.expiration_date = expiration_date;
        this.cvv = cvv;
    }
}
