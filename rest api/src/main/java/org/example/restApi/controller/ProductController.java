package org.example.restApi.controller;

import org.example.restApi.model.Product;
import org.example.restApi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String listProducts(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "product_list";
    }
    @GetMapping("/product/new")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product_form";
    }
    @PostMapping("/product/save")
    public String saveProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/products";
    }

    @PutMapping("/product/update/{id}")
    public String updateProduct(@PathVariable("id") Long id, @ModelAttribute Product updatedProduct) {
        Optional<Product> orderOptional = productRepository.findById(id);
        if (orderOptional.isPresent()) {
            Product existingProduct = orderOptional.get();
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            productRepository.save(existingProduct);
        }
        return "redirect:/products";
    }

    @DeleteMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productRepository.deleteById(id);
        return "redirect:/products";
    }
}
