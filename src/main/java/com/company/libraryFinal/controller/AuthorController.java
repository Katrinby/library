package com.company.libraryFinal.controller;

import com.company.libraryFinal.entity.Author;
import com.company.libraryFinal.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public String getAuthor(Model model, @RequestParam(defaultValue = "qwe1") String lname) {
        Author author = authorRepository.findAuthorByLname(lname);
        model.addAttribute("author", author);
        return "author";

    }

    @GetMapping("/{authorId}")
    public String getAuthorById(Model model, @PathVariable Long authorId) {
        Author author = authorRepository.findAuthorById(authorId);
        model.addAttribute("author", author);
        return "author";
    }

    @GetMapping("/search")
    public String getAuthors(Model model, @RequestParam String lname) {
        if (lname.isEmpty()) {
            List<Author> authors = authorRepository.findAll();
            model.addAttribute("authors", authors);
        } else {
            List<Author> authors = authorRepository.findAllByLnameContains(lname);
            model.addAttribute("authors", authors);
        }
        return "searchResults";

    }
}
