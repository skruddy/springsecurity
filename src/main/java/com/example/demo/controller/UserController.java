package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping(path = "/findAll")
    public ResponseEntity<List<User>> findAll (HttpServletRequest request) {
        log.info("Session id: {}",request.getSession().getId());
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<User> findUser(@PathVariable Integer id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/findByName/{name}")
    public ResponseEntity<User> findUser(@PathVariable String name){
        return new ResponseEntity<>(userService.findByUsername(name), HttpStatus.OK);
    }

    @PostMapping(path = "/register")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity(userService.registerUser(user), HttpStatus.OK);
    }

}
