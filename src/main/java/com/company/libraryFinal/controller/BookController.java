package com.company.libraryFinal.controller;
import com.company.libraryFinal.entity.*;
import com.company.libraryFinal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{bookId}")//todo придумать, что писать, если оценок еще нет(ноль может сбить с толку, хотя токой оценки и не существует)
    public String getBookById(Model model, @PathVariable Long bookId, @AuthenticationPrincipal Authentication auth){
        Book book = bookRepository.findBookById(bookId);
        model.addAttribute("book", book);
        BookSeries bookSeries = bookSeriesRepository.findBookSeriesByBooks(book);
        model.addAttribute("bookSeries", bookSeries);
        List<Comment> comments = commentRepository.findAllByBookId(bookId);
        model.addAttribute("comments", comments);
        User user = userRepository.findByUsername(auth.getName());
        model.addAttribute("user", user);
        markRepository.findAllByBookId(bookId);
        List<Mark> numbers = markRepository.findMarksByBookId(bookId);
        double counter = 0;
        for (Mark number:numbers){
            counter+=number.getMark();
        }
        double avg = counter/numbers.size();
        model.addAttribute("avg", avg);
        return "book";
    }

    @GetMapping("/{bookId}/read")
    public String read(Model model, @PathVariable Long bookId){
        Book book = bookRepository.findBookById(bookId);
        String text = book.getDescription();
        model.addAttribute("book", book);
        model.addAttribute("text", text);//допустим, что описание книги - и есть ее содержимое
        return "read";
    }

    @GetMapping("/{bookId}/chooseMark")
            public String chooseMark(Model model, @RequestParam("mark") Integer number,  @AuthenticationPrincipal Authentication auth,
                                     @PathVariable Long bookId)
    {
        Book book = bookRepository.findBookById(bookId);
        User user = userRepository.findByUsername(auth.getName());
        if (!markRepository.existsMarkByUserAndBook(user, book)) {
            Mark mark = new Mark(number);
            mark.setBook(book);
            mark.setUser(user);
            userRepository.save(user);
            markRepository.save(mark);
            Iterable<Mark> marks = markRepository.findAll();
            model.addAttribute("marks", marks);
            markRepository.save(mark);
        }
        Mark mark = markRepository.findMarkByUserAndBook(user, book);
        mark.setMark(number);
        markRepository.save(mark);
        Iterable<Mark> marks = markRepository.findAll();
        model.addAttribute("marks", marks);
        return "redirect:/book/"+bookId;
    }

    @GetMapping("/{bookId}/addComment")
    public String addComment(Model model, @RequestParam String text,  @AuthenticationPrincipal Authentication auth,
                             @PathVariable Long bookId)
    {//todo сделать ограничение на количество символов и подобрать размер окна ввода
        Book book = bookRepository.findBookById(bookId);
        User user = userRepository.findByUsername(auth.getName());
        Comment comment = new Comment(book, user, text);
        commentRepository.save(comment);
        model.addAttribute("comment", comment);
        return "redirect:/book/"+bookId;
    }

    @GetMapping("/search")
    public String getBooks(Model model, @RequestParam(defaultValue = "qwe2")String name){
        List<Book> books = bookRepository.findAllByName(name);
        model.addAttribute("books", books);
        return "searchResults";

    }
}
