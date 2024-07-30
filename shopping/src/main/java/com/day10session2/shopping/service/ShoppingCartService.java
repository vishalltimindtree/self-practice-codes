package com.day10session2.shopping.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day10session2.shopping.exception.InvalidInputException;
import com.day10session2.shopping.model.Product;
import com.day10session2.shopping.model.ShoppingCart;

@Service
public class ShoppingCartService {
    @Autowired
    private ProductService productService;

    @Autowired
    private ShoppingCart cart;

    public ShoppingCart getCart() {
        return cart;
    }

    public void addToCart(int productId) throws InvalidInputException {
        Product product = productService.getAllProducts().stream()
                .filter(p -> p.getProductId() == productId)
                .findFirst()
                .orElseThrow(() -> new InvalidInputException("Product not found"));

        cart.getItems().add(product);
        cart.setTotalPrice(cart.getTotalPrice() + product.getPrice());
    }

    public boolean removeFromCart(int productId) {
        Optional<Product> productOptional = cart.getItems().stream()
                .filter(p -> p.getProductId() == productId)
                .findFirst();

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            cart.getItems().remove(product);
            cart.setTotalPrice(cart.getTotalPrice() - product.getPrice());
            return true;
        }
        return false;
    }
}
