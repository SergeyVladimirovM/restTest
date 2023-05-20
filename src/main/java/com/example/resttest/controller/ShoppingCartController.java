package com.example.resttest.controller;

import com.example.resttest.entity.Product;
import com.example.resttest.service.ShoppingCartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("api/v1/shopping-cart")
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/{id}")
    public List<Product> getAllProductInShoppingCartCustomerById(@PathVariable("id") UUID customerId) {
        return shoppingCartService.findAllProductInShoppingCartCustomerById(customerId);
    }

    @PostMapping("/{id-customer}/{id-product}")
    public List<Product> saveProductInShoppingCartCustomerById(
            @PathVariable("id-customer") UUID customerId,
            @PathVariable("id-product") Long productId
    ) {
        return shoppingCartService.saveProductInShoppingCartCustomerById(customerId, productId);
    }

    @DeleteMapping("/{id-customer}/{id-product}")
    public List<Product> deleteProductInShoppingCartCustomerById(
            @PathVariable("id-customer") UUID customerId,
            @PathVariable("id-product") Long productId
    ) {
        return shoppingCartService.deleteProductInShoppingCartCustomerById(customerId, productId);
    }

    @DeleteMapping("/{id}")
    public List<Product> buyingAllProductInShoppingCartByIdCustomer(@PathVariable("id") UUID customerId) {
        return shoppingCartService.deleteAllProductInShoppingCartCustomer(customerId);
    }
}
