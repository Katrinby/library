package com.company.libraryFinal.controller;

import com.company.libraryFinal.entity.*;
import com.company.libraryFinal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private CommentRepository commentRepository;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookSeriesRepository bookSeriesRepository;

    @GetMapping("/{bookId}")
    public String getBookById(Model model, @PathVariable Long bookId, @AuthenticationPrincipal Authentication auth,
                              @PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Book book = bookRepository.findBookById(bookId);
        model.addAttribute("book", book);
        BookSeries bookSeries = bookSeriesRepository.findBookSeriesByBooks(book);
        model.addAttribute("bookSeries", bookSeries);

        Page<Comment> pages = commentRepository.findAllByBookId(bookId, pageable);
        model.addAttribute("number", pages.getNumber());
        model.addAttribute("totalPages", pages.getTotalPages());
        model.addAttribute("totalElements", pages.getTotalElements());
        model.addAttribute("size", 5);
        model.addAttribute("data", pages.getContent());

        User user = userRepository.findByUsername(auth.getName());
        model.addAttribute("user", user);
        markRepository.findAllByBookId(bookId);
        List<Mark> numbers = markRepository.findMarksByBookId(bookId);
        double counter = 0;
        for (Mark number : numbers) {
            counter += number.getMark();
        }
        double avg = counter / numbers.size();
        model.addAttribute("avg", avg);
        return "book";
    }

    @GetMapping("/{bookId}/read")
    public String read(Model model, @PathVariable Long bookId) {
        Book book = bookRepository.findBookById(bookId);
        String text = book.getDescription();
        model.addAttribute("book", book);
        model.addAttribute("text", text);//допустим, что описание книги - и есть ее содержимое
        return "read";
    }

    @GetMapping("/{bookId}/chooseMark")
    public String chooseMark(Model model, @RequestParam("mark") Integer number, @AuthenticationPrincipal Authentication auth,
                             @PathVariable Long bookId) {
        Book book = bookRepository.findBookById(bookId);
        User user = userRepository.findByUsername(auth.getName());
        Mark mark = null;
        if (!markRepository.existsMarkByUserAndBook(user, book)) {
            mark = new Mark(number);
            mark.setBook(book);
            mark.setUser(user);
        } else {
            mark = markRepository.findMarkByUserAndBook(user, book);
        }
        mark.setMark(number);
        markRepository.save(mark);
        Iterable<Mark> marks = markRepository.findAll();
        model.addAttribute("marks", marks);
        return "redirect:/book/" + bookId;
    }

    @GetMapping("/{bookId}/addComment")
    public String addComment(Model model, @RequestParam String text, @AuthenticationPrincipal Authentication auth,
                             @PathVariable Long bookId) {
        Book book = bookRepository.findBookById(bookId);
        User user = userRepository.findByUsername(auth.getName());
        Comment comment = new Comment(book, user, text);
        commentRepository.save(comment);
        model.addAttribute("comment", comment);
        return "redirect:/book/" + bookId;
    }

    @GetMapping("/search")
    public String getBooks(Model model, @RequestParam(defaultValue = "") String name,
                           @PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Book> pages;
        if (name.isEmpty()) {
            pages = bookRepository.findAll(pageable);
        } else {
            pages = bookRepository.findAllByNameContains(name, pageable);
        }
        model.addAttribute("number", pages.getNumber());
        model.addAttribute("totalPages", pages.getTotalPages());
        model.addAttribute("totalElements", pages.getTotalElements());
        model.addAttribute("size", 5);
        model.addAttribute("data", pages.getContent());
        return "searchResults";
    }
}
