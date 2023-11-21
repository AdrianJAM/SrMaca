package com.srmaca.model.ecommerce;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "inventory", schema = "ecommerce")
public class Inventory {

    @Id
    private Long id;

    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unit_price")
    private BigDecimal unit_price;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;
}
