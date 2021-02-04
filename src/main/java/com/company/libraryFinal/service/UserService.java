//
//package com.company.libraryFinal.service;
//
//import com.company.libraryFinal.entity.Role;
//import com.company.libraryFinal.entity.User;
//import com.company.libraryFinal.repository.RoleRepository;
//import com.company.libraryFinal.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> optionalUser = userService.findByUsername(username);
//
//        optionalUser
//                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
//        return optionalUser
//                .map(CustomUserDetail::new).get();
//    }
//}
//
