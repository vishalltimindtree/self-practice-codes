package com.day10session2.shopping.service;

import org.springframework.stereotype.Service;

import com.day10session2.shopping.exception.InvalidInputException;
import com.day10session2.shopping.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getProductId() == id) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product product) throws InvalidInputException {
        if (product.getProductId() == 0 || product.getProductName() == null || 
            product.getPrice() == 0.0 || product.getQuantityInStock() < 0) {
            throw new InvalidInputException("Invalid product input. Please check your data.");
        }
        products.add(product);
    }

    public Product updateProduct(int id, Product product) {
        for (Product p : products) {
            if (p.getProductId() == id) {
                p.setProductName(product.getProductName());
                p.setPrice(product.getPrice());
                p.setQuantityInStock(product.getQuantityInStock());
                return p;
            }
        }
        return null;
    }

    public boolean deleteProduct(int id) {
        for (Product p : products) {
            if (p.getProductId() == id) {
                products.remove(p);
                return true;
            }
        }
        return false;
    }
}
