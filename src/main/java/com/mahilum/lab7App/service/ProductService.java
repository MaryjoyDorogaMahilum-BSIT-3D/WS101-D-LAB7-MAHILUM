package com.mahilum.lab7App.service;

import com.mahilum.lab7App.model.Products;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private final Map<Long, Products> productMap = new HashMap<>();
    private Long nextId = 1L;

    public ProductService() {
        save(new Products(null, "Laptop", 50000.0));
        save(new Products(null, "Mouse", 500.0));
        save(new Products(null, "Keyboard", 1200.0));
    }

    public List<Products> getAll() {
        return new ArrayList<>(productMap.values());
    }

    public Optional<Products> getById(Long id) {
        return Optional.ofNullable(productMap.get(id));
    }

    public Products save(Products product) {
        if (product.getId() == null) {
            product.setId(nextId++);
        }
        productMap.put(product.getId(), product);
        return product;
    }

    public Optional<Products> update(Long id, Products updatedProduct) {
        if (productMap.containsKey(id)) {
            updatedProduct.setId(id);
            productMap.put(id, updatedProduct);
            return Optional.of(updatedProduct);
        }
        return Optional.empty();
    }

    public boolean delete(Long id) {
        return productMap.remove(id) != null;
    }
}
