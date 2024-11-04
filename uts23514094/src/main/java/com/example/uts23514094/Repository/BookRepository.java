package com.example.uts23514094.Repository;

import com.example.uts23514094.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
