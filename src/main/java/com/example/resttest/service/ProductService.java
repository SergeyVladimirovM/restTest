package com.example.resttest.service;

import com.example.resttest.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProduct();
    Product findProductById(Long id);
    Long saveProduct(Product product);
}
