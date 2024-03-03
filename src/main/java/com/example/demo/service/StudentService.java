package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> findAll () {
        return studentRepository.findAll();
    }

    public Student findById(Integer id){
        return studentRepository.findById(id).orElse(null);
    }

    public Student addUser(Student student){
        return studentRepository.save(student);
    }


}
