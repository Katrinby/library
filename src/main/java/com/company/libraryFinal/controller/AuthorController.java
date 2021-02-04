package com.company.libraryFinal.controller;

import com.company.libraryFinal.entity.Author;
import com.company.libraryFinal.entity.Book;
import com.company.libraryFinal.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping/*("/author")*/
    public String getAuthor(Model model, @RequestParam(defaultValue = "qwe1")String lname){
        Author author = authorRepository.findAuthorByLname(lname);
        model.addAttribute("author", author);
        return "author";

    }

    @GetMapping("/{authorId}")
    public String getAuthorById(Model model, @PathVariable Long authorId){
        Author author = authorRepository.findAuthorById(authorId);
        model.addAttribute("author", author);
        return "author";
    }

    @GetMapping("/search")
    public String getAuthors(Model model, @RequestParam(defaultValue = "qwe2")String lname){
        List<Author> authors = authorRepository.findAllByLname(lname);
        model.addAttribute("authors", authors);
        return "searchResults";

    }
}
