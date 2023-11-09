package com.srmaca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srmaca.model.ecommerce.Cart;
import com.srmaca.model.ecommerce.CartItem;
import com.srmaca.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping("/items")
    public List<CartItem> getCartItems(@RequestBody Cart cart) {
        return cartService.getCartItems(cart);
    }

    
}