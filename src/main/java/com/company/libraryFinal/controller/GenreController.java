package com.company.libraryFinal.controller;

import com.company.libraryFinal.entity.Genre;
import com.company.libraryFinal.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{genreId}")
    public String getBooksByGenre(Model model, @PathVariable Long genreId) {
        Genre genre = genreRepository.findGenreById(genreId);
        model.addAttribute("genre", genre);
        return "genre";
    }

    @GetMapping
    public String getAll(Model model) {
        List<Genre> genres = genreRepository.findAll();
        model.addAttribute("genre", genres);
        return "genre";
    }
}
