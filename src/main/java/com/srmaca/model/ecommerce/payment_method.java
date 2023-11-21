package com.srmaca.model.ecommerce;

import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "payment_methods", schema="ecommerce")
public class Payment_method{
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
}
