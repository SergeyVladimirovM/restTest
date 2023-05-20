package com.example.resttest.service;

import com.example.resttest.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ShoppingCartService {
    List<Product> findAllProductInShoppingCartCustomerById(UUID customerId);
    List<Product> saveProductInShoppingCartCustomerById(UUID customerId, Long productId);
    List<Product> deleteProductInShoppingCartCustomerById(UUID customerId, Long productId);
    List<Product> deleteAllProductInShoppingCartCustomer(UUID customerId);
}
