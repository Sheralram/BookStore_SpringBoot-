package com.bridgelabz.bookstorespringboot.repository;

import com.bridgelabz.bookstorespringboot.model.Cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query(value = "SELECT * FROM new_book_Store_spring.cart where user_id = :id", nativeQuery = true)
    List<Cart> findCartsByUserId(long id);

    @Query(value = "select * from new_book_Store_spring.cart where user_id = :id and book_id = :bookId", nativeQuery = true)
    Cart findCartsByUserIdAndBookId(long bookId, long id);

}
