package com.company.libraryFinal.repository;

import com.company.libraryFinal.entity.Book;
import com.company.libraryFinal.entity.BookSeries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookSeriesRepository  extends JpaRepository<BookSeries, Long> {
    BookSeries findBookSeriesByName(String name);
    Boolean existsBookSeriesByName(String name);

}
