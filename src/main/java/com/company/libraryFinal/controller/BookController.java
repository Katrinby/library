package com.company.libraryFinal.controller;
import com.company.libraryFinal.entity.Book;
import com.company.libraryFinal.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/{bookId}")
    public String getBookById(Model model, @PathVariable Long bookId){
        Book book = bookRepository.findBookById(bookId);
        model.addAttribute("book", book);
        return "book";
    }

    /*@GetMapping
    public String getBookByName(Model model, @RequestParam(defaultValue = "qwe")String name){
        Book book = bookRepository.findBookByName(name);
        model.addAttribute("book", book);
        return "book";
    }*/

    @GetMapping("/search")
    public String getBooks(Model model, @RequestParam(defaultValue = "qwe2")String name){
        List<Book> books = bookRepository.findAllByName(name);
        model.addAttribute("books", books);
        return "searchResults";

    }
}
