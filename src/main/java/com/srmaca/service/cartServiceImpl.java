package com.srmaca.service;

import java.math.BigDecimal;
import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.srmaca.model.ecommerce.Cart;
import com.srmaca.model.ecommerce.CartItem;
import com.srmaca.model.ecommerce.Product;
// import com.srmaca.repository.CartRepository;
// import com.srmaca.repository.productRepository;

@Service
public class CartServiceImpl implements CartService{
    
    /* @Autowired
    private CartRepository cartRepository; */
    /*  @Autowired
    private productRepository productRepository; */

    @Override
    public void addToCart(Cart cart, Product product, int quantity){
        //Verificar si el producto ya esta en el carrito
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem : cartItems){
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
        CartItem newCartItem = new CartItem();
        newCartItem.setProduct(product);
        newCartItem.setQuantity(quantity);
        BigDecimal subtotal = product.getPriceProduct().multiply(BigDecimal.valueOf(quantity));
        newCartItem.setSubtotal(subtotal);
        //Agrega el nuevo item al carrito
        cartItems.add(newCartItem);
    }

    @Override
    public void removeFromCart(Cart cart, Product product) {
        //Primero obtener la lista de items del carrito
        List<CartItem> cartItems = cart.getCartItems();
        //Luego itera sobre la lista de items del carrito para buscar el item a borrar
        for(CartItem cartItem : cartItems){
            //Si el item coincide, se borra
            if(cartItem.getProduct().equals(product)){
                cartItems.remove(cartItem);
                //Actualizar la lista de items del carrito
                cart.setCartItems(cartItems);

                //Calcular nuevo subtotal
                BigDecimal newSubtotal = calculateTotal(cart);
                cart.setSubtotal(newSubtotal);
                //Guarda los cambios en el carrito, por ejemplo, si estás usando un servicio o repositorio para almacenarlos
                break;
            }
        }
    }
    
    @Override
    public void clearCart(Cart cart) {
        // Obtiene la lista del carrito
        List<CartItem> cartItems = cart.getCartItems();
        // Itera a traves de la lista y elimina cada producto del carrito
        for(CartItem cartItem : cartItems){
            removeFromCart(cart, cartItem.getProduct());
        }
    }
    
    @Override
    public BigDecimal calculateTotal(Cart cart) {
        List<CartItem> cartItems = cart.getCartItems();
        BigDecimal total = BigDecimal.ZERO;

        for (CartItem cartItem : cartItems){
            BigDecimal productPrice = cartItem.getProduct().getPriceProduct();
            int quantity = cartItem.getQuantity();
            BigDecimal subtotal = productPrice.multiply(BigDecimal.valueOf(quantity));
            total = total.add(subtotal);
        }
        return total;
    }
}