package com.srmaca.service;

import com.srmaca.model.ecommerce.Product;
import java.util.List;

public interface ProductService {
    //Metodo para obtener todos los productos
    List<Product> getAllProducts();
    //Metodo para buscar producto por su ID
    Product getIdProduct(Long id);
    //Metodo para borrar producto
    void deleteProductById(Long id);
}