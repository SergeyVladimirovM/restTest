package com.example.resttest.service;

import com.example.resttest.entity.Customer;
import com.example.resttest.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final CustomerService customerService;
    private final ProductService productService;

    public ShoppingCartServiceImpl(CustomerService customerService, ProductService productService) {
        this.customerService = customerService;
        this.productService = productService;
    }

    @Override
    public List<Product> findAllProductInShoppingCartCustomerById(UUID customerId) {
        Customer customer = customerService.findCustomerById(customerId);
        return customer.getProductList();
    }

    @Override
    public List<Product> saveProductInShoppingCartCustomerById(UUID customerId, Long productId) {
        Customer customer = customerService.findCustomerById(customerId);
        List<Product> customerProductList = customer.getProductList();
        customerProductList.add(productService.findProductById(productId));
        customer.setProductList(customerProductList);
        customerService.saveCustomer(customer);
        return customer.getProductList();
    }

    @Override
    public List<Product> deleteProductInShoppingCartCustomerById(UUID customerId, Long productId) {
        Customer customer = customerService.findCustomerById(customerId);
        List<Product> customerProductList = customer.getProductList();
        customerProductList.remove(productService.findProductById(productId));
        customer.setProductList(customerProductList);
        customerService.saveCustomer(customer);
        return customer.getProductList();
    }

    @Override
    public List<Product> deleteAllProductInShoppingCartCustomer(UUID customerId) {
        Customer customer = customerService.findCustomerById(customerId);
        List<Product> customerProductList = customer.getProductList();
        customerProductList.clear();
        customer.setProductList(customerProductList);
        customerService.saveCustomer(customer);
        return customer.getProductList();
    }
}
