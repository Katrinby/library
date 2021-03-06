package com.company.libraryFinal.controller;

import com.company.libraryFinal.entity.BookSeries;
import com.company.libraryFinal.repository.BookRepository;
import com.company.libraryFinal.repository.BookSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/bookSeries")
public class BookSeriesController {

    @Autowired
    private BookSeriesRepository bookSeriesRepository;

    @GetMapping("/{bookSeriesId}")
    public String getBookById(Model model, @PathVariable Long bookSeriesId) {
        BookSeries bookSeries = bookSeriesRepository.findBookSeriesById(bookSeriesId);
        model.addAttribute("bookSeries", bookSeries);
        return "bookSeries";
    }
}
