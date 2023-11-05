package com.srmaca.model.ecommerce;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "order_details")
public class order_details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orderdetails")
    private Long id_order_details;

    @Column(name = "order_id")
    private Long order_id;

    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal unit_price;

    @Column(name = "subtotal", precision = 10, scale = 2, nullable = false)
    private BigDecimal subtotal;

    @Column(name = "created_at", updatable = false)
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;

    //CONSTRUCTOR
    public order_details(){}
    public order_details(Long order_id, Long product_id, Integer quantity, BigDecimal unit_price, BigDecimal subtotal) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.subtotal = subtotal;
        this.created_at = new Timestamp(System.currentTimeMillis());
        this.updated_at = new Timestamp(System.currentTimeMillis());
    }
    //GETTERS AND SETTERS
    //ID_ORDER_DETAILS
    public Long getIdOrderDetails() {
        return id_order_details;
    }
    public void setIdOrderDetails(Long id_order_details) {
        this.id_order_details = id_order_details;
    }
    //ORDER_ID
    public Long getOrderId() {
        return order_id;
    }
    public void setOrderId(Long order_id) {
        this.order_id = order_id;
    }
    //PRODUCT_ID
    public Long getProductId() {
        return product_id;
    }
    public void setProduct(Long product_id) {
        this.product_id = product_id;
    }
    //QUANTITY
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    //UNIT_PRICE
    public BigDecimal getUnitPrice() {
        return unit_price;
    }
    public void setUnitPrice(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }
    //SUBTOTAL
    public BigDecimal getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
    //CREATED_AT
    public Timestamp getCreatedAt() {
        return created_at;
    }
    public void setCreatedAt(Timestamp created_at) {
        this.created_at = created_at;
    }
    //UPDATED_AT
    public Timestamp getUpdatedAt() {
        return updated_at;
    }
    public void setUpdatedAt(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
