package com.srmaca.service;

import com.srmaca.model.ecommerce.product;
import java.util.List;

public interface productService {
    List<product> getAllProducts();
    product getIdProduct(Long id);
    void addToCart(Long productId, int quantity);
}