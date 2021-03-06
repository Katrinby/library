package com.company.libraryFinal.service;

import com.company.libraryFinal.entity.User;
import com.company.libraryFinal.repository.UserRepository;
import com.company.libraryFinal.to.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
            if (user==null){
                throw new UsernameNotFoundException("Username not found");
            }
        return UserSecurity.fromUser(user);
    }
}
