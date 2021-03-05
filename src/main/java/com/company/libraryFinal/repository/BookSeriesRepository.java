package com.company.libraryFinal.repository;

import com.company.libraryFinal.entity.Book;
import com.company.libraryFinal.entity.BookSeries;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookSeriesRepository  extends JpaRepository<BookSeries, Long> {
    BookSeries findBookSeriesByName(String name);
    BookSeries findBookSeriesById(Long id);
    BookSeries findBookSeriesByBooks(Book book);
    Boolean existsBookSeriesByName(String name);


}
