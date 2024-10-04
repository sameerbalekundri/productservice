package dev.naman.productservice.services;

import dev.naman.productservice.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long productId);
    List<Product> getProducts();

    Product createProduct(String title,
                          double price,
                          String category,
                          String description,
                          String image
    );
}
