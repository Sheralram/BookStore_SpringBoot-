package com.bridgelabz.bookstorespringboot.model;

import com.bridgelabz.bookstorespringboot.dto.BookDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Book")
@NoArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;


    private String name;
    private String author;

    private String img;
    private int price;
    private int quantity;

    @Column(length = 1000)
    private String description;


    public BookEntity(BookDto bookDto) {
        super();
        this.bookId = bookId;
        this.name = bookDto.getName();
        this.author = bookDto.getAuthor();
        this.img = bookDto.getImg();
        this.price = bookDto.getPrice();
        this.quantity = bookDto.getQuantity();
        this.description = bookDto.getDescription();
    }

    public BookEntity(long bookId, BookDto bookDto) {
        super();
        this.bookId = bookId;
        this.name = bookDto.getName();
        this.author = bookDto.getAuthor();
        this.img = bookDto.getImg();
        this.price = bookDto.getPrice();
        this.quantity = bookDto.getQuantity();
        this.description = bookDto.getDescription();
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }
}
