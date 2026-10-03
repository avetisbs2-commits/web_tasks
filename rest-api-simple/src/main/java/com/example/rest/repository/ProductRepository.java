package com.example.rest.repository;

import com.example.rest.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private final ArrayList<Product> products = new ArrayList<>();
    private int nextId = 1;

    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    public Product findById(int id) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    public Product create(Product product) {
        if (product == null) {
            return null;
        }

        product.setId(nextId);
        products.add(product);
        nextId++;
        return product;
    }

    public Product update(int id, Product product) {
        Product existingProduct = findById(id);
        if (existingProduct == null || product == null) {
            return null;
        }

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        return existingProduct;
    }

    public boolean isValid(Product product) {
        if (product == null) {
            return false;
        }

        if (product.getName() == null || product.getName().isBlank()) {
            return false;
        }

        if (product.getPrice() == null) {
            return false;
        }

        return product.getPrice().signum() >= 0;
    }

    public boolean deleteById(int id) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getId() == id) {
                products.remove(i);
                return true;
            }
        }

        return false;
    }
}
