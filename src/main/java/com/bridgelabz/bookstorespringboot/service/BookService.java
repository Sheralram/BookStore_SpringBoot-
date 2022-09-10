package com.bridgelabz.bookstorespringboot.service;

import com.bridgelabz.bookstorespringboot.dto.ResponseDto;
import com.bridgelabz.bookstorespringboot.exception.CustomException;
import com.bridgelabz.bookstorespringboot.model.BookEntity;
import com.bridgelabz.bookstorespringboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    public List<BookEntity> getAllList() {
        return bookRepository.findAll();
    }

    public BookEntity addBook(BookEntity bookEntity) {
       bookRepository.save(bookEntity);
       return bookEntity;
    }

    public List<BookEntity> bookSearch(String name) {
        if (bookRepository.findAllByNameStartingWith(name)!=null){
            return  bookRepository.findAllByNameStartingWith(name);
        }
        else{
            return null;
        }
    }

    public BookEntity getById(long bookId) {
        return bookRepository.findById( bookId)
                .orElseThrow(() -> new CustomException("Book  Id not Found!!!"));
    }

    public void deleteById(int bookId) {
        BookEntity bookEntity = this.getById(bookId);
           bookRepository.delete(bookEntity);

    }


}
