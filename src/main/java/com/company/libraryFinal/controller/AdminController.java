package com.company.libraryFinal.controller;
import com.company.libraryFinal.entity.Storage;
import com.company.libraryFinal.entity.User;
import com.company.libraryFinal.repository.StorageRepository;
import com.company.libraryFinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private UserRepository userRepository;

   // @RolesAllowed("ADMIN")
    @PreAuthorize("hasAnyRole(\"ROLE_ADMIN\")")
    @GetMapping
    public String getAll(Model model, @AuthenticationPrincipal Authentication auth){
        List<Storage> storages = storageRepository.findAll();
        User user = userRepository.findByUsername(auth.getName());
        model.addAttribute("storages", storages);
        model.addAttribute("user", user);
        return "adminCabinet";
    }

    @GetMapping("/storage/{id}")
    public String getBookById(Model model, @PathVariable Long id){
        Storage storage = storageRepository.findStorageById(id);
        model.addAttribute("storage", storage);
        return "storage";
    }
}
