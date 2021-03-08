package com.company.libraryFinal.controller;

import com.company.libraryFinal.entity.*;
import com.company.libraryFinal.repository.BookRepository;
import com.company.libraryFinal.repository.StorageRepository;
import com.company.libraryFinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;


    @PreAuthorize("hasAnyRole(\"ROLE_USER\")")
    @GetMapping
    public String getAll(Model model, @AuthenticationPrincipal Authentication auth){
        List<Storage> storages = storageRepository.findAll();
        User user = userRepository.findByUsername(auth.getName());
        model.addAttribute("storages", storages);
        model.addAttribute("user", user);
        return "userCabinet";
    }

    @PostMapping("/addStorage")
    public String addBook(@AuthenticationPrincipal Authentication auth, @RequestParam String name,
                          @RequestParam String publishingDate,
                          @RequestParam String description,
                          @RequestParam String genre, Map<String, Object> model) throws ParseException {

        if (!storageRepository.existsStorageByName(name)) {

            SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(publishingDate);
            User user = userRepository.findByUsername(auth.getName());
            Storage storage = new Storage(user, name, date, description, genre, false);
            storageRepository.save(storage);
            model.put("storage", storage);
            Iterable<Storage> storages = storageRepository.findAll();
            model.put("storages", storages);
        }
        return "userCabinet";
    }

    @GetMapping("/storage/{id}")
    public String getBookById(Model model, @PathVariable Long id){
        Storage storage = storageRepository.findStorageById(id);
        model.addAttribute("storage", storage);
        return "storage";
    }


}
