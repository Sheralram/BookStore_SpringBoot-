package com.bridgelabz.bookstorespringboot.service;

import com.bridgelabz.bookstorespringboot.dto.LoginDto;
import com.bridgelabz.bookstorespringboot.dto.UserDto;
import com.bridgelabz.bookstorespringboot.exception.CustomException;
import com.bridgelabz.bookstorespringboot.exception.UserBookRegistrationException;
import com.bridgelabz.bookstorespringboot.model.User;
import com.bridgelabz.bookstorespringboot.repository.UserRepository;
import com.bridgelabz.bookstorespringboot.response.Response;
import com.bridgelabz.bookstorespringboot.util.JwtToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userrepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder pwdencoder;

    @Autowired
    private JwtToken jwt;

    @Override
    public Response loginUser(LoginDto dto) {
        User user = userrepo.findByEmail(dto.getEmail()).orElseThrow(() -> new UserBookRegistrationException("login failed", HttpStatus.OK, null, "false"));
        boolean ispwd = pwdencoder.matches(dto.getPassword(), user.getPassword());
        if (ispwd == false) {
            throw new UserBookRegistrationException("login failed", HttpStatus.OK, null, "false");
        } else {
            String token = jwt.jwtToken(user.getUserId());
            return new Response(" Successfully login user", user, 200, token);
        }
    }

    @Override
    public User registerUser(UserDto userDto) {
        String encodedPassword = pwdencoder.encode(userDto.getPassword());
        userDto.setPassword(encodedPassword);
        User user = new User(encodedPassword, userDto.userName, userDto.email);
        return userrepo.save(user);
    }

    @Override
    public List<User> getAllListUser() {
        return userrepo.findAll();

    }

    @Override
    public User getByUserId(long userId) {
        return userrepo.findById(userId).orElseThrow(() -> new CustomException("User Not Found by Id"));
    }


}
