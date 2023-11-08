package com.srmaca.service;

import java.math.BigDecimal;
import com.srmaca.model.ecommerce.Cart;
import com.srmaca.model.ecommerce.Product;

public interface CartService {
    //Metodo para agregar al carrito
    void addToCart(Cart cart, Product product, int quantity);
    //Metodo para remover del carrito
    void removeFromCart(Cart cart, Product product);
    //Metodo para borrar carrito
    void clearCart(Cart cart);
    //Metodo para calcular total del carrito - checkout
    BigDecimal calculateTotal(Cart cart);
    //Metodo para guardar/actualizar carrito
    //void saveCart(Cart cart);
}