package com.company.libraryFinal.controller;

import com.company.libraryFinal.entity.Author;
import com.company.libraryFinal.entity.Book;
import com.company.libraryFinal.entity.Genre;
import com.company.libraryFinal.repository.AuthorRepository;
import com.company.libraryFinal.repository.BookRepository;
import com.company.libraryFinal.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    public String add(@RequestParam String name, @RequestParam String lname, Map<String, Object> model) {
        if (!authorRepository.existsAuthorByLname(lname) && !bookRepository.existsBookByName(name)) {
            Book book = new Book(name);
            Author author = new Author(lname);

            book.getAuthors().add(author);
            author.getBooks().add(book);

            authorRepository.save(author);
            bookRepository.save(book);

            Iterable<Author> authors = authorRepository.findAll();
            model.put("authors", authors);
            Iterable<Book> books = bookRepository.findAll();
            model.put("books", books);
        }
        return "main";
    }

    @GetMapping("/main")
    public String main(Model model) {
        List<Genre> genres = genreRepository.findAll();
        model.addAttribute("genres", genres);
        return "main";
    }

    @PostMapping("/main")
    public String filterByAuthor(@RequestParam String filterByAuthor, Map<String, Object> model) {
        return "main";
    }
}
