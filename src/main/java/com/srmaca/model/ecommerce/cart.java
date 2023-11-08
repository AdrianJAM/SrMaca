package com.srmaca.model.ecommerce;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.math.BigDecimal;

@Entity
@Table(name = "shopping_cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cart")
    private Long idCart;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "product_id")
    private Long product_id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "subtotal", precision = 10, scale = 2, nullable = false)
    private BigDecimal subtotal;

    @Column(name = "status", length = 50, nullable = false)
    private String status;

    @Column(name = "created_at", columnDefinition = "timestamp default current_timestamp")
    private Timestamp created_at;

    @Column(name = "updated_at", columnDefinition = "timestamp default current_timestamp")
    private Timestamp updated_at;

    //CONSTRUCTOR
    public Cart(){
    }
    public Cart(Long user_id, Long product_id, Integer quantity, BigDecimal subtotal, String status) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.status = status;
        this.created_at = new Timestamp(System.currentTimeMillis());
        this.updated_at = new Timestamp(System.currentTimeMillis());
    }
    //GETTERS AND SETTERS
    //ID_CART
    public Long getIdCart(){
        return idCart;
    }
    public void setIdCart(Long id_cart){
        this.idCart = id_cart;
    }
    //USER_ID
    public Long getUserId() {
        return user_id;
    }
    public void setUserId(Long user_id) {
        this.user_id = user_id;
    }
    //PRODUCT_ID
    public Long getProductId() {
        return product_id;
    }
    public void setProductId(Long product_id) {
        this.product_id = product_id;
    }
    //CART_ITEMS
    public List<CartItem> getCartItems(){
        return cartItems;
    }
    public void setCartItems(List<CartItem> cartItems){
        this.cartItems = cartItems;
    }
    //QUANTITY
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    //SUBTOTAL
    public BigDecimal getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
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
