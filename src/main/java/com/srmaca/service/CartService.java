package com.srmaca.service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.srmaca.model.ecommerce.Cart;
import com.srmaca.model.ecommerce.CartItem;
import com.srmaca.model.ecommerce.Product;
import com.srmaca.repository.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    private CartItemService cartItemService;

    public CartService(CartRepository cartRepository, CartItemService cartItemService){
        this.cartRepository = cartRepository;
        this.cartItemService = cartItemService;
    }
    // Metodo para obtener carrito por ID
    public Optional<Cart> getCartByIdCart(Long id_cart){
        return cartRepository.findByidCart(id_cart);
    }
    // Metodo para borrar carrito por ID
    public void deleteByidCart(Long id_cart){
        cartRepository.deleteByidCart(id_cart);
    }
    // Metodo para comprobar si el carrito existe
    public Boolean existsByidCart(Long idCart){
        return cartRepository.existsByidCart(idCart);
    }
    // Metodo para agregar item al carrito
    public void addToCart(Cart cart, Product product, int quantity) {
        Optional<CartItem> existingCartItem = cartItemService.findCartItem(product, cart);
        if (existingCartItem.isPresent()) {
            // Si el producto ya existe en el carrito, actualiza la cantidad
            CartItem cartItem = existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
            // Actualiza el subtotal
            cartItem.setSubtotal(cartItem.getProduct().getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity())));
            // Guarda la actualización
            cartItemService.saveCartItem(cartItem);
        } else {
            // Si el producto no existe, crea un nuevo CartItem
            CartItem newCartItem = new CartItem();
            newCartItem.setProduct(product);
            newCartItem.setCart(cart);
            newCartItem.setQuantity(quantity);
            newCartItem.setSubtotal(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
            // Guarda el nuevo CartItem
            cartItemService.saveCartItem(newCartItem);
        }
    }

    // Metodo para remover item del carrito
    public void removeFromCart(Cart cart, Product product) {
        Optional<CartItem> existingCartItem = cartItemService.findCartItem(product, cart);
        existingCartItem.ifPresent(cartItem -> {
            // Resta la cantidad del producto
            int newQuantity = cartItem.getQuantity() - 1;
            if (newQuantity <= 0) {
                // Si la cantidad es menor o igual a cero, elimina el elemento del carrito
                cartItemService.deleteCartItem(cartItem);
            } else {
                // Actualiza la cantidad y el subtotal
                cartItem.setQuantity(newQuantity);
                cartItem.setSubtotal(product.getPrice().multiply(BigDecimal.valueOf(newQuantity)));
                cartItemService.saveCartItem(cartItem);
            }
        });
    }

    // Metodo para limpiar el carrito
    public void clearCart(Cart cart) {
    List<CartItem> cartItems = cartItemService.getCartItems(cart);
    // Elimina todos los elementos del carrito
    cartItems.forEach(cartItemService::deleteCartItem);
    }

    // Método para calcular el total del carrito
    public BigDecimal calculateTotal(Cart cart) {
        List<CartItem> cartItems = cartItemService.getCartItems(cart);
        return cartItems.stream()
                .map(CartItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}