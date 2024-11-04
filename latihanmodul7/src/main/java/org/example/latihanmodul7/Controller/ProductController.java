package org.example.latihanmodul7.Controller;

import org.example.latihanmodul7.Model.Product;
import org.example.latihanmodul7.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product_list";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String editProductForm(@PathVariable Long id, Model model) {
        try {
            Product product = productService.getProductById(id);
            model.addAttribute("product", product);
            return "product_edit";
        } catch (RuntimeException e) {
            model.addAttribute("error", "Product not found for id :: " + id);
            return "product_list";  // Arahkan kembali kedaftar produk jika produk tidak ditemukan
        }
    }
    @PutMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String editProduct(@PathVariable Long id, @ModelAttribute("product") Product product) {
        product.setId(id);
        productService.saveProduct(product);
        return "redirect:/product/list";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/product/list";
    }

    // Menampilkan form untuk menambahkan produk baru
    @GetMapping("/add")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String showCreateProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product_add";
    }

    // Menyimpan produk baru
    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String addProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/product/list";
    }
}


