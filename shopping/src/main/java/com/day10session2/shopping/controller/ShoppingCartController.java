package com.day10session2.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.day10session2.shopping.exception.InvalidInputException;
import com.day10session2.shopping.model.ShoppingCart;
import com.day10session2.shopping.service.ShoppingCartService;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService cartService;

    @GetMapping
    public ResponseEntity<ShoppingCart> getCart() {
        return new ResponseEntity<>(cartService.getCart(), HttpStatus.OK);
    }

    @PostMapping("/add/{productId}")
    public ResponseEntity<String> addToCart(@PathVariable int productId) throws InvalidInputException {
        cartService.addToCart(productId);
        return new ResponseEntity<>("Product added to cart successfully", HttpStatus.OK);
    }

    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<String> removeFromCart(@PathVariable int productId) {
        boolean isRemoved = cartService.removeFromCart(productId);
        if (!isRemoved) {
            return new ResponseEntity<>("Product not found in the cart", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Product removed from the cart successfully", HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleInvalidInputException(InvalidInputException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
