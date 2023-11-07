package com.srmaca.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.srmaca.repository.productRepository;
import com.srmaca.model.ecommerce.product;

@Service
public class productServiceImpl implements productService{
    
    @Autowired
    private productRepository productRepository;

    //Metodo para obtener todos los productos
    @Override
    public List<product> getAllProducts() {
        return productRepository.findAll();
    }
    //Metodo para buscar producto por su ID
    @Override
    public product getIdProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    //Metodo para borrar producto
    @Override
    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }
}