package com.bridgelabz.bookstorespringboot.service;

import com.bridgelabz.bookstorespringboot.dto.AddressDetailsDto;
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

    public String add(AddressDetailsDto detailsDto) {
        Optional<User> user = userRepo.findById(detailsDto.getUserId());
        AddressDetails addressDetails = detailsRepository.findByUserAndType(user, detailsDto.getType());
        if (user != null) {
            if (addressDetails == null) {
                addressDetails = new AddressDetails(detailsDto.getName(), detailsDto.getPincode(),
                        detailsDto.getLocality(), detailsDto.getAddress(), detailsDto.getCity(),
                        detailsDto.getLandmark(), detailsDto.getType(), user.get());
                detailsRepository.save(addressDetails);
            }else {
                addressDetails.setName(detailsDto.getName());
                addressDetails.setPincode(detailsDto.getPincode());
                addressDetails.setLocality(detailsDto.getLocality());
                addressDetails.setAddress(detailsDto.getAddress());
                addressDetails.setCity(detailsDto.getCity());
                addressDetails.setLandmark(detailsDto.getLandmark());
                detailsRepository.save(addressDetails);
            }

            return "updated";
        } else
            return "user not found";
    }


}
