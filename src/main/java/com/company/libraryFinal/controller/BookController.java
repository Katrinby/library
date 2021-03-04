package com.company.libraryFinal.controller;
import com.company.libraryFinal.entity.Author;
import com.company.libraryFinal.entity.Book;
import com.company.libraryFinal.entity.Mark;
import com.company.libraryFinal.repository.BookRepository;
import com.company.libraryFinal.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MarkRepository markRepository;

    @GetMapping("/{bookId}")
    public String getBookById(Model model, @PathVariable Long bookId){
        Book book = bookRepository.findBookById(bookId);
        model.addAttribute("book", book);
        return "book";
    }

    @PostMapping("/chooseMark")
            public String chooseMark(Model model, @PathVariable Integer mark)
    {
        Mark newMark = new Mark(mark);
        markRepository.save(newMark);
        Iterable<Mark> marks = markRepository.findAll();
        model.addAttribute("newMark", newMark);
        return "book";
    }

    /*@PostMapping("book/addMark")
    public String addMark(@RequestParam Integer mark, Map<String, Object> model) {

            Mark mark = new Mark(lname, fname);
            authorRepository.save(author);
            Iterable<Author> authors = authorRepository.findAll();
            model.put("authors", authors);

        return "main";
    }*/

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
