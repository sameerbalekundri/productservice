package dev.naman.productservice.controllers;

import dev.naman.productservice.dtos.CreateProductRequestDto;
import dev.naman.productservice.dtos.FakeStoreProductDto;
import dev.naman.productservice.models.Product;
import dev.naman.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    private RestTemplate restTemplate;

    public ProductController(@Qualifier("selfProductService") ProductService productService,
                             RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") long productId) {
        return productService.getSingleProduct(productId);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto request) {
        return productService.createProduct(
                request.getTitle(),
                request.getPrice(),
                request.getCategory(),
                request.getDescription(),
                request.getImage()
        );
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/products/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable("category") String productCategory) {
        return productService.getProductsByCategory(productCategory);
    }

    @GetMapping("/products/categories")
    public List<String> getAllProductCategories() {
        return productService.getAllProductCategories();
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") long productId,
                                 @RequestBody FakeStoreProductDto productDto) {
        return productService.updateProduct(
                productId,
                productDto.getTitle(),
                productDto.getPrice(),
                productDto.getDescription(),
                productDto.getImage(),
                productDto.getCategory()
        );
    }

    @DeleteMapping("/products/{id}")
    public Product deleteProduct(@PathVariable("id") long productId) {
        return productService.deleteProduct(productId);
    }
}
