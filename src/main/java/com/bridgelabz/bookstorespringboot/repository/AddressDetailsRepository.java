package com.bridgelabz.bookstorespringboot.repository;

import com.bridgelabz.bookstorespringboot.model.AddressDetails;
import com.bridgelabz.bookstorespringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressDetailsRepository extends JpaRepository<AddressDetails, Integer> {
    public AddressDetails findByUserAndType(Optional<User> user, int type);
}