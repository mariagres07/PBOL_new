package org.example.latihanmodul7.Service;

import org.example.latihanmodul7.Model.Product;
import org.example.latihanmodul7.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {

            throw new RuntimeException("Product not found for id :: " + id);
        }
    }
    // Menghapus produk berdasarkan ID
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

