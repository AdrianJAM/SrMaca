package com.srmaca.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.srmaca.model.ecommerce.Cart;
import com.srmaca.model.ecommerce.CartItem;
import com.srmaca.model.ecommerce.Product;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long>{
    // Metodo para obtener lista de items del carrito
    List<CartItem> findByCart(Cart cart);
    // Metodo para obtener un solo item del carrito
    Optional<CartItem> findByProductAndCart(Product product, Cart cart);
    // Metodo para contar la cantidad total de items en el carrito
    Long countByCart(Cart cart);
    // Metodo para sumar el total de los precios de los items en el carrito
    BigDecimal sumPriceByCart(Cart cart);
}
