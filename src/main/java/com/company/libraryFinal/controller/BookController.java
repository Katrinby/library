package com.company.libraryFinal.controller;
import com.company.libraryFinal.entity.Book;
import com.company.libraryFinal.entity.BookSeries;
import com.company.libraryFinal.entity.Mark;
import com.company.libraryFinal.entity.User;
import com.company.libraryFinal.repository.BookRepository;
import com.company.libraryFinal.repository.BookSeriesRepository;
import com.company.libraryFinal.repository.MarkRepository;
import com.company.libraryFinal.repository.UserRepository;
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
    private UserRepository userRepository;

    @Autowired
    private BookSeriesRepository bookSeriesRepository;

    @GetMapping("/{bookId}")//todo придумать, что писать, если оценок еще нет(ноль может сбить с толку, хотя токой оценки и не существует)
    public String getBookById(Model model, @PathVariable Long bookId){
        Book book = bookRepository.findBookById(bookId);
        model.addAttribute("book", book);
        BookSeries bookSeries = bookSeriesRepository.findBookSeriesByBooks(book);
        model.addAttribute("bookSeries", bookSeries);
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
            public String chooseMark(Model model, @RequestParam("mark") Integer number,  @AuthenticationPrincipal Authentication auth, @PathVariable Long bookId)
    {
        Book book = bookRepository.findBookById(bookId);
        User user = userRepository.findByUsername(auth.getName());
        if (!markRepository.existsMarkByUser(user)) {
            Mark mark = new Mark(number);
            mark.setBook(book);
            mark.setUser(user);
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

    @GetMapping("/search")
    public String getBooks(Model model, @RequestParam(defaultValue = "qwe2")String name){
        List<Book> books = bookRepository.findAllByName(name);
        model.addAttribute("books", books);
        return "searchResults";

    }
}
