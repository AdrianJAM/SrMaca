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
@Table(name = "purchase_history", schema = "ecommerce")
public class Purchase_history {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_purchase_history")
    private Long id_purchase_history;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "order_id")
    private Long order_id;

    @Column(name = "purchase_date")
    private Timestamp purchase_date;

    @Column(name = "total_amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal total_amount;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;
}
