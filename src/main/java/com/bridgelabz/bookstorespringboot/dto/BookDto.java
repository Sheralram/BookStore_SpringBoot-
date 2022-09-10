package com.bridgelabz.bookstorespringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {

    private String name;
    private String author;
    private String description;
    private String img;
    private int price;
    private int quantity;

}
