package com.srmaca.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.srmaca.repository.productRepository;
import com.srmaca.model.ecommerce.cart;
import com.srmaca.model.ecommerce.product;

@Service
public class productServiceImpl implements productService{
    
    @Autowired
    private productRepository productRepository;

    @Autowired
    private cartService cartService;

    @Override
    public List<product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public product getIdProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void addToCart(Long productId, int quantity) {
        product product = productRepository.findById(productId).orElse(null);
    }
}