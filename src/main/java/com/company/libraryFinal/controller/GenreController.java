package com.company.libraryFinal.controller;

import com.company.libraryFinal.entity.Book;
import com.company.libraryFinal.entity.Genre;
import com.company.libraryFinal.repository.BookRepository;
import com.company.libraryFinal.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private BookRepository bookRepository;


    @GetMapping("/{genreId}")
    public String getBooksByGenre(Model model, @PathVariable Long genreId,
                                  @PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Genre genre = genreRepository.findGenreById(genreId);
        model.addAttribute("genre", genre);
        Page<Book> pages = bookRepository.findBooksByGenre(genre, pageable);
        model.addAttribute("number", pages.getNumber());
        model.addAttribute("totalPages", pages.getTotalPages());
        model.addAttribute("totalElements", pages.getTotalElements());
        model.addAttribute("size", 5);
        model.addAttribute("data",pages.getContent());
        return "genre";
    }

    @GetMapping
    public String getAll(Model model) {
        List<Genre> genres = genreRepository.findAll();
        model.addAttribute("genre", genres);
        return "genre";
    }
}
