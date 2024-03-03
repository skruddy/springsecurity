package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CentralController {


    @GetMapping("/getCsrfToken")
    public ResponseEntity<CsrfToken> getCsrfToken(HttpServletRequest request){
        return new ResponseEntity<>((CsrfToken) request.getAttribute("_csrf"), HttpStatus.OK);

    }
}
