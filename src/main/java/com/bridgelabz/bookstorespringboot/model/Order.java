package com.bridgelabz.bookstorespringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="orderData")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;


    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    int quantity;
    double totalPrice;
    private String address;

    boolean cancel = false;
    public LocalDate orderDate = LocalDate.now();

    public Order( Cart cart, int quantity, double totalPrice,String address ) {
        this.cart = cart;
        this.orderDate = LocalDate.now();
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.address = address;
    }


}
