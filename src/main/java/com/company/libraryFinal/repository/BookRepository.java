package com.company.libraryFinal.repository;
import com.company.libraryFinal.entity.Book;
import com.company.libraryFinal.entity.BookSeries;
import com.company.libraryFinal.entity.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findBookById(Long id);
    List<Book> findAll();
    Page<Book> findAll(Pageable pageable);
    List<Book> findAllByNameContains(String name);
    Page<Book> findAllByNameContains(String name, Pageable pageable);
    List<Book> findBooksByBookSeries(BookSeries bookSeries);
    boolean existsBookByName (String name);

    Page<Book> findBooksByGenre(Genre genre, Pageable pageable);
    List<Book> findBooksByGenre(Genre genre);
}
