package com.bridgelabz.bookstorespringboot.dto;

import com.bridgelabz.bookstorespringboot.model.BookEntity;
import com.bridgelabz.bookstorespringboot.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartDto {


    public long bookId;
    public long user_Id;
    public int quantity;
    double totalPrice;
}
