package com.company.libraryFinal.controller;

import com.company.libraryFinal.entity.Book;
import com.company.libraryFinal.entity.Storage;
import com.company.libraryFinal.entity.User;
import com.company.libraryFinal.repository.BookRepository;
import com.company.libraryFinal.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/storage")
public class StorageController {


        @Autowired
        private StorageRepository storageRepository;

        @GetMapping("/{id}")
        public String getBookById(Model model, @PathVariable String id){
            List<Storage> storages = storageRepository.findAll();
            model.addAttribute("storage", storages);
            return "book";
        }

        /*@GetMapping
        public String getBookByName(Model model, @RequestParam(defaultValue = "qwe")String name){
            Book book = bookRepository.findBookByName(name);
            model.addAttribute("book", book);
            return "book";

    }*/
}
