package dev.naman.productservice.controllers;

import dev.naman.productservice.models.Product;
import dev.naman.productservice.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public void createProduct() {

    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") long productId) {
        return productService.getSingleProduct(productId);
    }

    @GetMapping("/products")
    public void getAllProducts() {

    }

    public void updateProductDetails() {

    }
}
