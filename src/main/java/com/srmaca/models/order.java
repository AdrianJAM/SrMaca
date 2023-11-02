package com.srmaca.models;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class order {
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

    public order(){
    }

    //Getters AND Setters
    //ID_ORDER
    public Long getIdOrder(){
        return id_order;
    }
    public void setIdOrder(Long id_order){
        this.id_order = id_order;
    }
    //ID_USER
    public Long getIdUser(){
        return user_id;
    }
    public void setIdUser(Long user_id){
        this.user_id = user_id;
    }
    //Order_Date
    public Timestamp getOrderDate(){
        return orderDate;
    }
    public void setOrdeDate(Timestamp orderDate){
        this.orderDate = orderDate;
    }
    //ORDER_STATUS
    public String getOrderStatus(){
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus){
        this.orderStatus = orderStatus;
    }
    //TOTAL_AMOUNT
    public double getTotalAmount(){
        return total_amount;
    }
    public void setTotalAmount(double total_amount){
        this.total_amount = total_amount;
    }
    //SHIPPING_ADDRESSES
    public String getShippingAddress(){
        return shipping_address;
    }
    public void setShippingAddress(String shipping_address){
        this.shipping_address = shipping_address;
    }
    //PAYMENT_METHOD
    public String getPaymentMethod(){
        return payment_method;
    }
    public void setPaymentMethod(String payment_method){
        this.payment_method = payment_method;
    }
    //CREATED_AT
    public Timestamp getCreatedAt(){
        return created_at;
    }
    public void setCreatedAt(Timestamp created_at){
        this.created_at = created_at;
    }
    //UPDATED_AT
    public Timestamp getUpdatedAt(){
        return updated_at;
    }
    public void setUpdatedAt(Timestamp updated_at){
        this.updated_at = updated_at;
    }
}