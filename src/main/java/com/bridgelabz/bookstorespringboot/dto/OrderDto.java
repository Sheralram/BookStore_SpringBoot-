package com.bridgelabz.bookstorespringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    public long cartId;
    public int quantity;
    public double totalPrice;
    public String address;

}
