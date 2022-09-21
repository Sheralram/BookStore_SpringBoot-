package com.bridgelabz.bookstorespringboot.service;

import com.bridgelabz.bookstorespringboot.dto.ResponseDto;
import com.bridgelabz.bookstorespringboot.exception.CustomException;
import com.bridgelabz.bookstorespringboot.model.BookEntity;
import com.bridgelabz.bookstorespringboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class BookService {

    private static final String BOOK_DETAILS_ADDED = "Book Data Added";
    @Autowired
    private BookRepository bookRepository;

    String line=""; 
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



    public ResponseDto saveBookData() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new
                    FileReader("src/main/resources/books_data.csv"));
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                BookEntity bookEntity = new BookEntity();
                bookEntity.setAuthor(data[1].replaceAll("'", ""));
                bookEntity.setName(data[2].replaceAll("'", ""));
                bookEntity.setQuantity(Integer.parseInt(data[3]));
                bookEntity.setImg(data[4]);
                bookEntity.setPrice(Integer.parseInt(data[5]));
                IntStream.range(7, data.length - 1).forEach(column -> data[6] += "," + data[column]);
                bookEntity.setDescription(data[6]);
                bookRepository.save(bookEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseDto(BOOK_DETAILS_ADDED, null);
    }


    public List<BookEntity> getBookByAscendingPrice() {
        List<BookEntity> bookDataList = bookRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(bookDetails -> bookDetails.getPrice()))
                .collect(Collectors.toList());
        return bookDataList;
    }

    public List<BookEntity> getBookByDescendingPrice() {
        List<BookEntity> bookDataList = bookRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(bookDetails -> bookDetails.getPrice()))
                .collect(Collectors.toList());
        Collections.reverse(bookDataList);
        return bookDataList;
    }
}
