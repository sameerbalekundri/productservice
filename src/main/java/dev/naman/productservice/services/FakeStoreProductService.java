package dev.naman.productservice.services;

import dev.naman.productservice.dtos.FakeStoreProductDto;
import dev.naman.productservice.dtos.FakeStoreProductsByCategoryDto;
import dev.naman.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        FakeStoreProductDto fakeStoreProduct = restTemplate.getForObject (
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class
        );

        return fakeStoreProduct.toProduct();
    }

    @Override
    public Product createProduct(String title,
                                 double price,
                                 String category,
                                 String description,
                                 String image) {

        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setImage(image);

        FakeStoreProductDto response = restTemplate.postForObject (
                "https://fakestoreapi.com/products",
                fakeStoreProductDto,
                FakeStoreProductDto.class
        );

        return response.toProduct();
    }

//    public List<Product> getProductsByCategory(String category) {
//        FakeStoreProductsByCategoryDto fakeStoreProductsByCategory = restTemplate.getForObject (
//                "https://fakestoreapi.com/products/" + category + "/",
//                FakeStoreProductsByCategoryDto.class
//                );
//
//        return fakeStoreProductsByCategory.toProductList();
//    }

    @Override
    public List<Product> getProducts() {
        FakeStoreProductDto[] fakeStoreProducts = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
                );
        List<Product> products = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProducts) {
            products.add(fakeStoreProductDto.toProduct());
        }
        return products;
    }
}
