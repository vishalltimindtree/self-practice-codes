package com.day10session2.shopping.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    private List<Product> items = new ArrayList<>();
    private double totalPrice;

    public ShoppingCart() {
    }

    public ShoppingCart(List<Product> items, double totalPrice) {
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
