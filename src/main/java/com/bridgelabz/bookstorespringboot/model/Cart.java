package com.bridgelabz.bookstorespringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@Entity
@Table(name = "Cart")
@NoArgsConstructor

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartId", nullable = false)
    private Long cartId;


    @ManyToOne
    @JoinColumn(name = "bookId")
    public BookEntity book;


    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_Id")
    public User user;


    public int quantity;
    public double totalPrice;



    public Cart(User user_Id, BookEntity bookId, int quantity, double totalPrice) {
        this.book = bookId;
        this.user = user_Id;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }





}
