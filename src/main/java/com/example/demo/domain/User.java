package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;

import java.util.List;

@Entity
@Setter
@Slf4j
@ToString
public class User {
    @JsonProperty("id")
    private Long id;
    @Getter
    private String username;
    @Getter
    private String password;
    @Getter
    private String role;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

}
