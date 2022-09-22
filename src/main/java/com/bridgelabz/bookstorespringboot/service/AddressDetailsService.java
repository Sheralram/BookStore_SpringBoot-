package com.bridgelabz.bookstorespringboot.service;

import com.bridgelabz.bookstorespringboot.dto.AddressDetailsDto;
import com.bridgelabz.bookstorespringboot.exception.CustomException;
import com.bridgelabz.bookstorespringboot.model.AddressDetails;
import com.bridgelabz.bookstorespringboot.model.User;
import com.bridgelabz.bookstorespringboot.repository.AddressDetailsRepository;
import com.bridgelabz.bookstorespringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressDetailsService {

    @Autowired
    AddressDetailsRepository detailsRepository;

    @Autowired
    UserRepository userRepo;

    public AddressDetails add(AddressDetailsDto detailsDto) {
        Optional<User> user = userRepo.findById(detailsDto.getUserId());
        if (user.isPresent()) {
            AddressDetails addressDetails = new AddressDetails(detailsDto, user.get());
            return detailsRepository.save(addressDetails);
        } else
            throw new CustomException("User Not Found");
    }


}
