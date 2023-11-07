package com.srmaca.service;

import com.srmaca.model.ecommerce.cart;

public interface cartService {
    cart getCurrenCart();
    void updateCart(cart cart);
}
