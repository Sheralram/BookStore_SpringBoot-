package com.bridgelabz.bookstorespringboot.service;

import com.bridgelabz.bookstorespringboot.dto.LoginDto;
import com.bridgelabz.bookstorespringboot.dto.UserDto;
import com.bridgelabz.bookstorespringboot.exception.UserBookRegistrationException;
import com.bridgelabz.bookstorespringboot.model.User;
import com.bridgelabz.bookstorespringboot.response.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {

    public Response loginUser(LoginDto dto)throws UserBookRegistrationException;

    User registerUser(UserDto userDTO);

   public List<User> getAllListUser();

    public User getByUserId(long userId);

}
