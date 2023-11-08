package com.srmaca.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.srmaca.model.ecommerce.Cart;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
    //Metodo para obtener Cart por ID
    Optional<Cart> findByidCart(Long id_cart);
    //Metodo para borrar Cart por ID
    void deleteByidCart(Long idCart);
    //Metodo para ver si el Cart existe
    boolean existsByidCart(Long idCart);
}