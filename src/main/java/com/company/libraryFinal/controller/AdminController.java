package com.company.libraryFinal.controller;
import com.company.libraryFinal.entity.Storage;
import com.company.libraryFinal.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StorageRepository storageRepository;

    @GetMapping
    public String getAll(Model model){
        List<Storage> storages = storageRepository.findAll();
        model.addAttribute("storages", storages);
        return "adminCabinet";
    }

    @GetMapping("/storage/{id}")
    public String getBookById(Model model, @PathVariable Long id){
        Storage storage = storageRepository.findStorageById(id);
        model.addAttribute("storage", storage);
        return "storage";
    }
}
