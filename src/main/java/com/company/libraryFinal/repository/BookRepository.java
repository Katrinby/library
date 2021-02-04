package com.company.libraryFinal.repository;

import com.company.libraryFinal.entity.Author;
import com.company.libraryFinal.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findBookByName(String name);
    Book findBookById(Long id);
    List<Book> findAllByName(String name);
    boolean existsBookByName (String name);
}
