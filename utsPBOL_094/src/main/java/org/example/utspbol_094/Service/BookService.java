package org.example.utspbol_094.Service;

import org.example.utspbol_094.Model.Book;
import org.example.utspbol_094.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    public BookRepository bookRepository;

    public List<Book> getAllBooks(){ return bookRepository.findAll();}

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book updatedBook){
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book existingBook = bookOptional.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setIsbn(updatedBook.getIsbn());
            return bookRepository.save(existingBook);
        }
        return null;
    }
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
