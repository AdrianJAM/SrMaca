package com.srmaca.model.ecommerce;

import jakarta.persistence.*;
import java.sql.Timestamp;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "orders", schema = "ecommerce")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id_order;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "order_date")   
    private Timestamp orderDate;

    @Column(name = "status")
    private String orderStatus;

    @Column(name = "total_amount")
    private double total_amount;

    @Column(name = "shipping_address")
    private String shipping_address;

    @Column(name = "payment_method")
    private String payment_method;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;
}