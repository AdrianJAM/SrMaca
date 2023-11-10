package com.srmaca.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.srmaca.model.ecommerce.Cart;
import com.srmaca.model.ecommerce.CartItem;
import com.srmaca.model.ecommerce.Product;
import com.srmaca.repository.CartItemRepository;

@Service
public class CartItemService {
    
    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> getCartItems(Cart cart){
        return cartItemRepository.findByCart(cart);
    }

    public Long getCountTotalItems(Cart cart){
        return cartItemRepository.countByCart(cart);
    }

    public BigDecimal getSumTotalCart(Cart cart){
        return cartItemRepository.sumPriceByCart(cart);
    }

    public Optional<CartItem> findCartItem(Product product, Cart cart){
        return cartItemRepository.findByProductAndCart(product, cart);
    }

    public void saveCartItem(CartItem cartItem){
        cartItemRepository.save(cartItem);
    }

    public void deleteCartItem(CartItem cartItem){
        cartItemRepository.delete(cartItem);
    }
}
