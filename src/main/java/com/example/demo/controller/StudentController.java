package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
@Slf4j
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(path = "/findAll")
    public ResponseEntity<List<Student>> findAll (HttpServletRequest request) {
        log.info("Session id: {}",request.getSession().getId());
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<Student> findUser(@PathVariable Integer id){
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity addUser(@RequestBody Student student){
        studentService.addUser(student);
        return new ResponseEntity(HttpStatus.OK);
    }

}
