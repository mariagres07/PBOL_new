package com.example.uts23514094.Controller;

import com.example.uts23514094.Model.Book;
import com.example.uts23514094.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    // Menampilkan daftar semua buku
    @GetMapping("/books")
    public String getAllBook(Model model){
        List<Book> books = bookService.getAllBook();
        model.addAttribute("books", books);
        return "books";
        //Mengarahkan ke file products.html
    }

    //Menampilkan form untuk menambahkan produk baru
    @GetMapping("/book/new")
    public String showCreateProductFormModel(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        System.out.println("Product object sent to the view: " + book);
        return "book_form";
    }

    //Menambahkan buku baru
    @PostMapping("/book/save")
    public  String saveBook(Book book){
        bookService.saveBook(book);
        return "redirect:/books";
    }

    //Menampilkan form untuk mengedit produk
    @GetMapping("/book/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Long id, Model model){
        Book product = bookService.getBookById(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("product", product);
        return "book_form";
        // Mengarahkan ke file product_form.html
    }
    // Menghapus buku
    @GetMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id, Model model){
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
