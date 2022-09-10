package com.bridgelabz.bookstorespringboot.repository;

import com.bridgelabz.bookstorespringboot.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    public BookEntity findByName(String Name);

    public List<BookEntity> findAllByNameStartingWith(String Name);


}
