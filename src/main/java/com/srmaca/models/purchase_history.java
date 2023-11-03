package com.srmaca.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "purchase_history")
public class purchase_history {
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

    //CONSTRUCTOR
    public purchase_history(){}
    public purchase_history(Long id_purchase_history, Long user_id, Long order_id, Timestamp purchase_date, BigDecimal total_amount, String status, Timestamp created_at, Timestamp updated_at){
        this.id_purchase_history = id_purchase_history;
        this.user_id = user_id;
        this.order_id = order_id;
        this.purchase_date = purchase_date;
        this.total_amount = total_amount;
        this.status = status;
        this.created_at = new Timestamp(System.currentTimeMillis());
        this.updated_at = new Timestamp(System.currentTimeMillis());
    }

    //GETTERS AND SETTERS
    //ID_PURCHASE_HISTORY
    public Long getIdPurchaseHistory() {
        return id_purchase_history;
    }
    public void setIdPurchaseHistory(Long id_purchase_history) {
        this.id_purchase_history = id_purchase_history;
    }
    //USER_ID
    public Long getUserId() {
        return user_id;
    }
    public void setUserId(Long user_id) {
        this.user_id = user_id;
    }
    //ORDER_ID
    public Long getOrderId() {
        return order_id;
    }
    public void setOrderId(Long order_id) {
        this.order_id = order_id;
    }
    //PURCHASE_DATE
    public Timestamp getPurchaseDate() {
        return purchase_date;
    }
    public void setPurchaseDate(Timestamp purchase_date) {
        this.purchase_date = purchase_date;
    }
    //TOTAL_AMOUNT
    public BigDecimal getTotalAmount() {
        return total_amount;
    }
    public void setTotalAmount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }
    //STATUS
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
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
