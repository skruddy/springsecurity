package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    public User registerUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> findAll () {
        return userRepository.findAll();
    }

    public User findById(@PathVariable Integer id){
        return userRepository.findById(id).orElse(null);
    }

    public User findByUsername(@PathVariable String name){
        return userRepository.findByUsername(name);
    }
}
