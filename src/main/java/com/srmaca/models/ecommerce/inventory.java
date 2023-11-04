package com.srmaca.models.ecommerce;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "inventory")
public class inventory {
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

    //CONSTRUCTOR
    public inventory(){}
    public inventory(Long product_id, Integer quantity, BigDecimal unit_price, Timestamp created_at, Timestamp updated_at){
        this.product_id = product_id;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
    //GETTERS AND SETTERS
    //PRODUCT_ID
    public Long getProductId(){
        return product_id;
    }
    public void setProductId(Long product_id){
        this.product_id = product_id;
    }
    //QUANTITY
    public Integer getQuantity(){
        return quantity;
    }
    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }
    //UNIT_PRICE
    public BigDecimal getUnitPrice(){
        return unit_price;
    }
    public void setUnitPrice(BigDecimal unit_price){
        this.unit_price = unit_price;
    }
    //CREATED_AT
    public Timestamp getCreatedAt(){
        return created_at;
    }
    //UPDATED_AT
    public void setCreatedAt(Timestamp updated_at){
        this.updated_at = updated_at;
    }
}
