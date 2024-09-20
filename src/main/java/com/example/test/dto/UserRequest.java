package com.example.test.dto;
import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String surname;
    private Integer age;
    private String password;

}
