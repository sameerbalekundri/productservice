package dev.naman.productservice.services;

import dev.naman.productservice.models.Category;
import dev.naman.productservice.models.Product;
import dev.naman.productservice.repositories.CategoryRepository;
import dev.naman.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Product getSingleProduct(Long productId) {
        return productRepository.findByIdIs(productId);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(String title, double price, String category, String description, String image) {
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageUrl(image);

        Category categoryFromDataBase = categoryRepository.findByTitle(category);

        if (categoryFromDataBase == null) {
            Category newCategory = new Category();
            newCategory.setTitle(category);
            categoryFromDataBase = newCategory;
        }

        product.setCategory(categoryFromDataBase);

        Product savedProduct = productRepository.save(product);

        return savedProduct;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return List.of();
    }

    @Override
    public List<String> getAllProductCategories() {
        return List.of();
    }

    @Override
    public Product updateProduct(Long productId, String title, double price, String category, String description, String image) {
        return null;
    }

    @Override
    public Product deleteProduct(Long productId) {
        return null;
    }
}
