package com.company.libraryFinal.controller;

import com.company.libraryFinal.entity.*;
import com.company.libraryFinal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Collections;

@Controller
@RequestMapping("/storage")
public class StorageController {


    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private BookSeriesRepository bookSeriesRepository;


    @PreAuthorize("hasAnyRole(\"ROLE_ADMIN\")")
    @GetMapping("/{storageId}/edit")
    public String chooseMark(Model model, @RequestParam("answer") boolean answer, @PathVariable Long storageId) {
        Storage storage = storageRepository.findStorageById(storageId);
        User user = storage.getUser();
        storage.setStatus(answer);
        storageRepository.save(storage);
        model.addAttribute("storage", storage);
        if (answer) {
            if (!genreRepository.existsGenreByName(storage.getGenre())) {
                Genre genre = new Genre(storage.getGenre());
                genreRepository.save(genre);
                Iterable<Genre> genres = genreRepository.findAll();
                model.addAttribute("genres", genres);
                genreRepository.save(genre);
            }
            Genre genre = genreRepository.findGenreByName(storage.getGenre());
            BookSeries bookSeries = bookSeriesRepository.findBookSeriesById(3l);

            Book book = new Book();
            book.setName(storage.getName());
            book.setGenre(Collections.singletonList(genre));
            book.setDescription(storage.getDescription());
            book.setBookSeries(bookSeries);
            book.setPublishingDate(storage.getYearOfPublishing());
            Author author = new Author();
            if (!authorRepository.existsAuthorByLnameAndFname(user.getUserInfo().getLname(),user.getUserInfo().getFname())) {
            author.setFname(user.getUserInfo().getFname());
            author.setLname(user.getUserInfo().getLname());
            author.setDateBirth(user.getUserInfo().getDateBirth());
            author.setBooks(Collections.singletonList(book));
            book.setAuthors(Collections.singletonList(author));
            } else {
                author = authorRepository.findFirstByFnameAndLname(user.getUserInfo().getFname(), user.getUserInfo().getLname());
            }
            bookSeriesRepository.save(bookSeries);
            authorRepository.save(author);
            bookRepository.save(book);
            storageRepository.delete(storage);
            return "redirect:/admin";
        }
        return "storage";
    }

    @GetMapping("/{storageId}/read")
    public String read(Model model, @PathVariable Long storageId){
        Storage storage = storageRepository.findStorageById(storageId);
        String text = storage.getDescription();
        model.addAttribute("storage", storage);
        model.addAttribute("text", text);//допустим, что описание книги - и есть ее содержимое
        return "read";
    }
}
