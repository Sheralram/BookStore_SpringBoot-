package com.bridgelabz.bookstorespringboot.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDto {
    public String userName;
    public String email;
    public String password;


}