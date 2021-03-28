package com.company.libraryFinal.controller;

import com.company.libraryFinal.entity.Author;
import com.company.libraryFinal.entity.Book;
import com.company.libraryFinal.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public String getAuthors(Model model, @RequestParam(defaultValue = "") String lname,
                             @PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Author> pages;
        if (lname.isEmpty()) {
            pages = authorRepository.findAll(pageable);
        } else {
            pages = authorRepository.findAllByLnameContains(lname, pageable);
        }
        model.addAttribute("anumber", pages.getNumber());
        model.addAttribute("atotalPages", pages.getTotalPages());
        model.addAttribute("atotalElements", pages.getTotalElements());
        model.addAttribute("asize", 5);
        model.addAttribute("adata",pages.getContent());
        return "searchResults";

    }
}
