package com.example.restapidemo.service;

import com.example.restapidemo.model.Product;
import com.example.restapidemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }
    public Optional<Product> getProductById(Long id) {
        return productRepository.getProductById(id);
    }
    public Product addProduct(Product product) {
        return productRepository.addProduct(product);
    }
    public Product updateProduct(Long id, Product updatedProduct) {
        return productRepository.updateProduct(id, updatedProduct);
    }
    public boolean deleteProduct(Long id) {
        return productRepository.deleteProduct(id);
    }
}
