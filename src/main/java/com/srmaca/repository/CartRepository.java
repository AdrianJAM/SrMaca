package com.srmaca.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.srmaca.model.ecommerce.Cart;
import com.srmaca.model.ecommerce.CartItem;
import com.srmaca.model.ecommerce.Product;
//import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
    //Metodo para obtener Cart por ID
    Optional<Cart> findByidCart(Long id_cart);
    //Metodo para borrar Cart por ID
    void deleteByidCart(Long idCart);
    //Metodo para ver si el Cart existe
    boolean existsByidCart(Long idCart);
    //Metodo para agregar al carrito    
    void addToCart(Cart cart, Product product, int quantity);
    //Metodo para remover del carrito
    void removeFromCart(Cart cart, Product product);
    //Metodo para limpiar items del carrito
    void clearCart(Cart cart);
    //Metodo para calcular total del carrito - checkout
    //BigDecimal calculateTotal(Cart cart);
    //Metodo para guardar/actualizar carrito
    void saveCart(Cart cart);
    //Metodo par obtener items del carrito
    List<CartItem> getCartItems(Cart cart);
}