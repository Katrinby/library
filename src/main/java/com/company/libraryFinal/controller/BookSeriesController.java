package com.company.libraryFinal.controller;

import com.company.libraryFinal.entity.Book;
import com.company.libraryFinal.entity.BookSeries;
import com.company.libraryFinal.entity.Mark;
import com.company.libraryFinal.repository.BookRepository;
import com.company.libraryFinal.repository.BookSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bookSeries")
public class BookSeriesController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookSeriesRepository bookSeriesRepository;

    @GetMapping("/{bookSeriesId}")   public String getBookById(Model model, @PathVariable Long bookSeriesId){
        BookSeries bookSeries = bookSeriesRepository.findBookSeriesById(bookSeriesId);
        model.addAttribute("bookSeries", bookSeries);
        /*List<Book> books = bookRepository.findBooksByBookSeries(bookSeries);
        model.addAttribute("books", books);*/
        return "bookSeries";
    }

}
