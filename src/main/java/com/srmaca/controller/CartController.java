package com.srmaca.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.srmaca.model.ecommerce.Cart;
import com.srmaca.model.ecommerce.CartItem;
import com.srmaca.model.ecommerce.Product;
import com.srmaca.service.CartService;
import com.srmaca.service.ProductService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    //private ProductService productService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long cartId) {
        Optional<Cart> cart = cartService.getCartByIdCart(cartId);
        return cart.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}