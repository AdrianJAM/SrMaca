package com.srmaca.model.ecommerce;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "promotions_and_discounts", schema = "ecommerce")
public class Prom_discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prom_discount")
    private Long id_prom_discount;

    @Column(name = "code", length = 50)
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private Timestamp start_date;

    @Column(name = "end_date")
    private Timestamp end_date;

    @Column(name = "discount_type", length = 50)
    private String type_discount;

    @Column(name = "discount_value", precision = 10, scale = 2, nullable = false)
    private BigDecimal value_discount;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;
}