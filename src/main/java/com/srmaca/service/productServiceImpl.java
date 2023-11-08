package com.srmaca.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.srmaca.repository.ProductRepository;
import com.srmaca.model.ecommerce.Product;

@Service
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    private ProductRepository ProductRepository;

    //Metodo para obtener todos los productos
    @Override
    public List<Product> getAllProducts() {
        return ProductRepository.findAll();
    }
    //Metodo para buscar producto por su ID
    @Override
    public Product getIdProduct(Long id) {
        return ProductRepository.findById(id).orElse(null);
    }
    //Metodo para borrar producto
    @Override
    public void deleteProductById(Long id){
        ProductRepository.deleteById(id);
    }
}