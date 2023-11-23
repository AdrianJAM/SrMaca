package com.srmaca.model.ecommerce;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import lombok.*;
import com.srmaca.model.users.Users;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "orders", schema = "ecommerce")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long idOrder;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id_user")
    private Users user;

    @ManyToMany
    private List<Product> products;

    @Column(name = "order_date")   
    private Timestamp orderDate;

    @Column(name = "status")
    private String orderStatus;

    @Column(name = "total_amount")
    private BigDecimal total_amount;

    @Column(name = "shipping_address")
    private String shipping_address;

    @Column(name = "payment_method")
    private String payment_method;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;
}