package com.example.restapidemoo.controller;

import com.example.restapidemoo.model.Product;
import com.example.restapidemoo.repository.ProductRepository;
import com.example.restapidemoo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    // Mendapatkan semua produk
    @GetMapping("/products")
    public String viewProducts(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
        //Mengarahkan ke file products.html
    }

    //Menampilkan form untuk menambahkan produk baru
    @GetMapping("/product/new")
    public String showCreateProductFormModel(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        System.out.println("Product object sent to the view: " + product);
        return "product_form";
    }

    //Menyimpan produk baru
    @PostMapping("/product/save")
    public  String saveProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/products";
    }

    //Menampilkan form untuk mengedit produk
    @GetMapping("/product/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Long id, Model model){
        Product product = productService.getProductById(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("product", product);
        return "product_form";
        // Mengarahkan ke file product_form.html
    }
    // Menghapus produk
    @GetMapping("/product/delete/{id}")
    public String productService(@PathVariable("id") Long id, Model model){
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}


