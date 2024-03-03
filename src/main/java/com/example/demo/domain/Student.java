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

@Entity
@Setter
@Slf4j
@ToString
public class Student {
    @JsonProperty("id")
    private Long id;
    @Getter
    @JsonProperty("name")
    private String name;
    @Getter
    @JsonProperty("email")
    private String email;
    @Getter
    @JsonProperty("contact")
    private String contact;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }


}
