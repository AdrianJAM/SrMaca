package com.srmaca.model.ecommerce;

import java.sql.Timestamp;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "shipping_addresses")
public class Shipping_address {
    @Id
    @Column(name = "id_address")
    private Long id_address;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "recipient_name", length = 255)
    private String recipient_name;

    @Column(name = "street_address")
    private String street_name;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "state", length = 100)
    private String state;

    @Column(name = "postal_code", length = 20)
    private String postal_code;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "phone_number", length = 20)
    private String phone_number;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;
}