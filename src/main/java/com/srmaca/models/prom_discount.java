package com.srmaca.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "promotions_and_discounts")
public class prom_discount {
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

    //CONSTRUCTOR
    public prom_discount(){}
    public prom_discount(Long id_prom_discount, String code, String description, Timestamp start_date, Timestamp end_date, String type_discount, BigDecimal value_discount, Timestamp created_at, Timestamp updated_at){
        this.id_prom_discount = id_prom_discount;
        this.code = code;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.type_discount = type_discount;
        this.value_discount = value_discount;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
    //GETTERS AND SETTERS
    //ID_PROM_DISCOUNT
    public Long getIdPromDiscount(){
        return id_prom_discount;
    }
    public void setIdPromDiscount(Long id_prom_discount){
        this.id_prom_discount = id_prom_discount;
    }
    //CODE
    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }
    //DESCRIPTION
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    //START_DATE
    public Timestamp getStartDate(){
        return start_date;
    }
    public void setStartDate(Timestamp start_date){
        this.start_date = start_date;
    }
    //END_DATE
    public Timestamp getEndDate(){
        return end_date;
    }
    public void setEndDate(Timestamp end_date){
        this.end_date = end_date;
    }
    //TYPE_DISCOUNT
    public String getTypeDiscount(){
        return type_discount;
    }
    public void setTypeDiscount(String type_discount){
        this.type_discount = type_discount;
    }
    //VALUE_DISCOUNT
    public BigDecimal getValue_Discount(){
        return value_discount;
    }
    public void setValue_Discount(BigDecimal value_discount){
        this.value_discount = value_discount;
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
