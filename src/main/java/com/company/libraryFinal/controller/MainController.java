package com.company.libraryFinal.controller;

import com.company.libraryFinal.entity.Author;
import com.company.libraryFinal.entity.Book;
import com.company.libraryFinal.entity.BookSeries;
import com.company.libraryFinal.entity.Genre;
import com.company.libraryFinal.repository.AuthorRepository;
import com.company.libraryFinal.repository.BookRepository;
import com.company.libraryFinal.repository.BookSeriesRepository;
import com.company.libraryFinal.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private BookSeriesRepository bookSeriesRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("main/addBook")
    public String addBook(@RequestParam String name, @RequestParam String lname, @RequestParam String publishingHouse,
                          @RequestParam String publishingDate,
                          @RequestParam String description, @RequestParam String bookSeriesName, @RequestParam String bookSeriesDescription,
                          @RequestParam String genre, Map<String, Object> model) throws ParseException {

        if (!bookRepository.existsBookByName(name)) {

            if (!bookSeriesRepository.existsBookSeriesByName(bookSeriesName)) {
                BookSeries bookSeries = new BookSeries(bookSeriesName);
                bookSeries.setDescription(bookSeriesDescription);
                bookSeriesRepository.save(bookSeries);
            }

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(publishingDate);

            BookSeries bookSeries = bookSeriesRepository.findBookSeriesByName(bookSeriesName);

            Book book = new Book(name, publishingHouse, date, description, bookSeries);

            if (!authorRepository.existsAuthorByLname(lname)) {

                Author author = new Author(lname);
                authorRepository.save(author);
                Iterable<Author> authors = authorRepository.findAll();
                model.put("authors", authors);
                authorRepository.save(author);
            }
            Author author = authorRepository.findAuthorByLname(lname);

            if (!genreRepository.existsGenreByName(genre)) {
                Genre newGenre = new Genre(genre);
                genreRepository.save(newGenre);
                Iterable<Genre> genres = genreRepository.findAll();
                model.put("genres", genres);
                genreRepository.save(newGenre);
            }

            Genre newGenre = genreRepository.findGenreByName(genre);

            book.setAuthors(Collections.singletonList(author));
            book.setGenre(Collections.singletonList(newGenre));
            author.getBooks().add(book);
            newGenre.getBooks().add(book);

            bookRepository.save(book);
            authorRepository.save(author);
            genreRepository.save(newGenre);


            Iterable<Genre> genres = genreRepository.findAll();
            model.put("genres", genres);
            Iterable<Author> authors = authorRepository.findAll();
            model.put("authors", authors);
            Iterable<Book> books = bookRepository.findAll();
            model.put("books", books);
        }
        return "redirect:/main";
    }

    @PostMapping("main/addAuthor")
    public String addAuthor(@RequestParam String fname, @RequestParam String lname, @RequestParam String dateBirth,
                            Map<String, Object> model) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(dateBirth);
        if (!authorRepository.existsAuthorByLname(lname)) {
            Author author = new Author(lname, fname);
            author.setDateBirth(date);
            authorRepository.save(author);
            Iterable<Author> authors = authorRepository.findAll();
            model.put("authors", authors);
        }
        return "redirect:/main";
    }

    @PostMapping("main/addGenre")
    public String addGenre(@RequestParam String name, Map<String, Object> model) {
        if (!genreRepository.existsGenreByName(name)) {
            Genre genre = new Genre(name);
            genreRepository.save(genre);
            Iterable<Genre> genres = genreRepository.findAll();
            model.put("genres", genres);
        }
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String main(Model model,
                       @PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Genre> pages = genreRepository.findAll(pageable);
        model.addAttribute("number", pages.getNumber());
        model.addAttribute("totalPages", pages.getTotalPages());
        model.addAttribute("totalElements", pages.getTotalElements());
        model.addAttribute("size", 5);
        model.addAttribute("data",pages.getContent());
        return "main";
    }

    @PostMapping("/main")
    public String filterByAuthor() {
        return "main";
    }

}
