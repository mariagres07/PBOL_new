package com.example.restapidemo.repository;

import com.example.restapidemo.model.Product;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private List<Product> products = new ArrayList<>();
    private long idCounter = 0;

    public List<Product> getAllProducts() {
        return products;
    }
    public Optional<Product> getProductById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
    public Product addProduct(Product product) {
        product.setId(++idCounter);
        products.add(product);
        return product;
    }
    public Product updateProduct(Long id, Product updatedProduct) {
        Optional<Product> existingProduct = getProductById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            return product;
        } else {
            return null;
        }
    }
    public boolean deleteProduct(Long id) {
        return products.removeIf(p -> p.getId().equals(id));
    }
}
