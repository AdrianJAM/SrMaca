package com.srmaca.service;

import com.srmaca.model.ecommerce.product;
import java.util.List;

public interface productService {
    //Metodo para obtener todos los productos
    List<product> getAllProducts();
    //Metodo para buscar producto por su ID
    product getIdProduct(Long id);
    //Metodo para borrar producto
    void deleteProductById(Long id);
}