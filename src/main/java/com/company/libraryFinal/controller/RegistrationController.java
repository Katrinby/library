package com.company.libraryFinal.controller;


import com.company.libraryFinal.entity.User;
import com.company.libraryFinal.repository.RoleRepository;
import com.company.libraryFinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Resource(name = "pencoder")
    private PasswordEncoder passwordEncoder;

   /* @Autowired
    private AuthenticationManager authenticationManager;*/

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Map<String, Object> model,@RequestParam String username, @RequestParam String password) {
        User userFromDb = userRepository.findByUsername(username);
        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }
        User user = new User(username, password);
        user.setActive(true);
        user.setRoles(Collections.singleton(roleRepository.findByRole("USER")));
        userRepository.save(user);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /*@PostMapping("/loginUser")
    public String login(Map<String, Object> model, @RequestParam String username, @RequestParam String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            model.put("message", "User is not exists!");
            return "login";
        }
        if(!passwordEncoder.matches(password,user.getPassword())){
            model.put("message", "Wrong password!");
            return "login";
        }
        return "redirect:/main";
    }*/
}
