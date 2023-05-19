package com.example.resttest.controller;

import com.example.resttest.dto.ProductInput;
import com.example.resttest.entity.Product;
import com.example.resttest.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("api/v1/product")
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public List<Product> getAllProduct() {
        return productService.findAllProduct();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.findProductById(id);
    }

    @PostMapping("/")
    public Long saveProduct(@RequestBody ProductInput productInput) {
        Product product = new Product();
        product.setTitle(productInput.getTitle());
        product.setPrice(productInput.getPrice());
        return productService.saveProduct(product);
    }
}
