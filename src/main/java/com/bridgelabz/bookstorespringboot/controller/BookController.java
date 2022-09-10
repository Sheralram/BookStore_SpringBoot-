package com.bridgelabz.bookstorespringboot.controller;

import com.bridgelabz.bookstorespringboot.dto.BookDto;
import com.bridgelabz.bookstorespringboot.dto.ResponseDto;
import com.bridgelabz.bookstorespringboot.model.BookEntity;
import com.bridgelabz.bookstorespringboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("/list")
    public ResponseEntity<ResponseDto> getAllBookList() {
        ResponseDto responseDto = new ResponseDto("List of Books", bookService.getAllList());
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @RequestMapping("/{bookId}")
    public ResponseEntity<ResponseDto> getBookById(@PathVariable int bookId) {
        ResponseDto responseDto = new ResponseDto("Book Id is found", bookService.getById(bookId));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @PostMapping("/addBook")
    public ResponseEntity<ResponseDto> addBook(@RequestBody BookDto bookDto) {
        BookEntity bookEntity = new BookEntity(bookDto);
        ResponseDto responseDto = new ResponseDto("Book Added Successfully", bookService.addBook(bookEntity));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/search/{name}")
    public ResponseEntity<ResponseDto> searchBookByName(@PathVariable String name) {
        ResponseDto responseDto = new ResponseDto("Book:", bookService.bookSearch(name));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping(value = {"/remove/{bookId}"})
    public ResponseEntity<ResponseDto> removeAddressBookData(@PathVariable int bookId) {
        bookService.deleteById(bookId);
        ResponseDto responseDTO = new ResponseDto("Data DELETED Successfully!!!",
                "ID number: " + bookId + " --> DELETED!!!");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


}
