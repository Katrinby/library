package com.company.libraryFinal.controller;


import com.company.libraryFinal.entity.User;
import com.company.libraryFinal.entity.UserInfo;
import com.company.libraryFinal.repository.RoleRepository;
import com.company.libraryFinal.repository.UserInfoRepository;
import com.company.libraryFinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Resource(name = "pencoder")
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Map<String, Object> model, @RequestParam String username, @RequestParam String password,
                          @RequestParam String dateBirth,
                          @RequestParam String fname, @RequestParam String lname) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(dateBirth);
        User userFromDb = userRepository.findByUsername(username);
        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }
        User user = new User(username, password);
        userRepository.save(user);
        UserInfo userInfo = new UserInfo(lname, fname, date, user);
        user.setUserInfo(userInfo);
        user.setRoles(Collections.singleton(roleRepository.findRoleByRole("ROLE_USER")));
        user.setActive(true);
        userInfoRepository.save(userInfo);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
