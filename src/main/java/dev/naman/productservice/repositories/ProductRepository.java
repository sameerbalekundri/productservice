package dev.naman.productservice.repositories;

import dev.naman.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);

    @Override
    List<Product> findAll();

    Product findByIdIs(Long id);

    List<Product> findAllByTitle(String title);
}
