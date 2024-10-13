package dev.naman.productservice.repositories;

import dev.naman.productservice.models.Category;
import dev.naman.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByIdIs(Long id);

    @Override
    List<Product> findAll();

    List<Product> findByCategory(Category category);

//    List<Product> findAllCategories();
}
