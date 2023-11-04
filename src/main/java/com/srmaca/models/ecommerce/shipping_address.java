package com.srmaca.models.ecommerce;

import java.sql.Timestamp;
import jakarta.persistence.*;

@Entity
@Table(name = "shipping_addresses")
public class shipping_address {
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

    //CONSTRUCTOR
    public shipping_address(){}
    public shipping_address(Long id_address, Long user_id, String recipient_name, String street_address, String city, String state, String postal_code, String country, String phone_number, Timestamp created_at, Timestamp updated_at){
        this.id_address = id_address;
        this.user_id = user_id;
        this.recipient_name = recipient_name;
        this.street_name = street_address;
        this.state = state;
        this.postal_code = postal_code;
        this.country = country;
        this.phone_number = phone_number;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    //GETTERS AND SETTERS
    //ID_ADDRESS
    public Long getIdAddress(){
        return id_address;
    }
    public void setIdAddress(Long id_address){
        this.id_address = id_address;
    }
    //USER_ID
    public Long getUserId(){
        return user_id;
    }
    public void setUserId(Long user_id){
        this.user_id = user_id;
    }
    //RECIPIENT_NAME
    public String getRecipientName(){
        return recipient_name;
    }
    public void setRecipientName(String recipient_name){
        this.recipient_name = recipient_name;
    }
    //STREET_ADDRESS
    public String getStreetAddress(){
        return street_name;
    }
    public void  setStreetAddress(String street_address){
        this.street_name = street_address;
    }
    //STATE
    public String getState(){
        return state;
    }
    public void setState(String state){
        this.state = state;
    }
    //COUNTRY
    public String getCountry(){
        return country;
    }
    public void setCountry(String country){
        this.country = country;
    }
    //PHONE_NUMBER
    public String getPhoneNumber(){
        return phone_number;
    }
    public void setPhoneNumber(String phone_number){
        this.phone_number = phone_number;;
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