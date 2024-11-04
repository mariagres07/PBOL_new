package org.example.utspbol_094.Controller;

import org.springframework.ui.Model;
import org.example.utspbol_094.Model.Book;
import org.example.utspbol_094.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public String getAllBook(Model model){
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "book_list";
    }

    @GetMapping("/book/new")
    public String showBookForm(org.springframework.ui.Model model) {
        model.addAttribute("book", new Book());
        return "book_form";
    }

    @PostMapping("/book/save")
    public String saveBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/books";
    }

    @GetMapping("/book/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model){
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            model.addAttribute("book", bookOptional.get());
            return "book_form";
        }
        return "redirect:/books";
    }

    @PutMapping("/book/update/{id}")
    public String updateBook(@PathVariable("id") Long id, @ModelAttribute Book updatedBook) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book existingBook = bookOptional.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setIsbn(updatedBook.getIsbn());

            bookRepository.save(existingBook);
        }
        return "redirect:/books";
    }

    @GetMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
}
