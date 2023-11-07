package com.srmaca.service;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.srmaca.model.ecommerce.cart;
import com.srmaca.model.ecommerce.cartItem;
import com.srmaca.model.ecommerce.product;
import com.srmaca.repository.cartRepository;
import com.srmaca.repository.productRepository;

@Service
public class cartServiceImpl implements cartService{

    /*  @Autowired
    private cartRepository cartRepository;

    @Autowired
    private productRepository productRepository; */

    @Override
    public void addToCart(cart cart, product product, int quantity){
        //Verificar si el producto ya esta en el carrito
        List<cartItem> cartItems = cart.getCartItems();
        for (cartItem cartItem : cartItems){
            if(cartItem.getProduct().equals(product)){
                //El producto ya esta en el carrito, actualiza la cantidad y el total
                int newQuantity = cartItem.getQuantity() + quantity;
                cartItem.setQuantity(newQuantity);
                BigDecimal newSubtotal = product.getPriceProduct().multiply(BigDecimal.valueOf(newQuantity));
                cartItem.setSubtotal(newSubtotal);
                return;
            }
        }
        //El producto no esta en el carrito, crea uno nuevo item
        cartItem newCartItem = new cartItem();
        newCartItem.setProduct(product);
        newCartItem.setQuantity(quantity);
        BigDecimal subtotal = product.getPriceProduct().multiply(BigDecimal.valueOf(quantity));
        newCartItem.setSubtotal(subtotal);
        //Agrega el nuevo item al carrito
        cartItems.add(newCartItem);
    }

    @Override
    public void removeFromCart(cart cart, product product) {
        //Primero obtener la lista de items del carrito
        List<cartItem> cartItems = cart.getCartItems();
        //Luego itera sobre la lista de items del carrito para buscar el item a borrar
        for(cartItem cartItem : cartItems){
            //Si el item coincide, se borra
            if(cartItem.getProduct().equals(product)){
                cartItems.remove(cartItem);
                //Actualizar la lista de items del carrito
                cart.setCartItems(cartItems);

                //Calcular nuevo subtotal
                //BigDecimal newSubtotal = calculateTotal(cart);
                //cart.setSubtotal(newSubtotal);
                // Guarda los cambios en el carrito, por ejemplo, si estás usando un servicio o repositorio para almacenarlos
                // cartService.saveCart(cart);
                break;
            }
        }
    }
    
    @Override
    public void clearCart(cart cart) {
        
    }
    
    /* @Override
    public BigDecimal calculateTotal(cart cart) {
        // Implementa la lógica para calcular el total del carrito
        return 0.0; // Debes retornar el valor correcto
    } */
}