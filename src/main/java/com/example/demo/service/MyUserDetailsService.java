package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.domain.UserPrincipal;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        log.info("User fetched from db: {}", user);

        if (user==null) {
            log.info("User 404");
            throw new UsernameNotFoundException("User 404");
        }
        return new UserPrincipal(user);
        }
    }
