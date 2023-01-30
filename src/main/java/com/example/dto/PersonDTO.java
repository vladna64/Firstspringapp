package com.example.dto;

import lombok.Data;

@Data
public class PersonDTO {
    private long id;
    private String firstname;
    private String lastname;
    private Integer age;
    private Boolean start;
    private Double procent;
    private char des_score;
}
