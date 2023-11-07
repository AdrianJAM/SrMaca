package com.srmaca.service;

import java.math.BigDecimal;

import com.srmaca.model.ecommerce.cart;
import com.srmaca.model.ecommerce.product;


public interface cartService {
    //Metodo para agregar al carrito
    void addToCart(cart cart, product product, int quantity);
    //Metodo para remover del carrito
    void removeFromCart(cart cart, product product);
    //Metodo para borrar carrito
    void clearCart(cart cart);
    //Metodo para calcular total del carrito - checkout
    //BigDecimal calculateTotal(cart cart);
}
