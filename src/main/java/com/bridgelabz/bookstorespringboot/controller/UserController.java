package com.bridgelabz.bookstorespringboot.controller;

import com.bridgelabz.bookstorespringboot.dto.LoginDto;
import com.bridgelabz.bookstorespringboot.dto.ResponseDto;
import com.bridgelabz.bookstorespringboot.dto.UserDto;
import com.bridgelabz.bookstorespringboot.model.User;
import com.bridgelabz.bookstorespringboot.response.Response;
import com.bridgelabz.bookstorespringboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/loginuser")
    public ResponseEntity<Response> loginUser(@RequestBody LoginDto dto, BindingResult result) {
        Response respDTO = userService.loginUser(dto);
        return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
    }


    @PostMapping(value = {"/register"})
    public User registerUser(@RequestBody UserDto userDTO) {
        return userService.registerUser(userDTO);
    }


    @GetMapping("/listUsers")
    public ResponseEntity<ResponseDto> getAllUsers() {
        ResponseDto responseDto = new ResponseDto("List Users:", userService.getAllListUser());
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }


    @PutMapping("/getById/{userId}")
    public ResponseEntity<ResponseDto> getByUserId(@PathVariable long userId) {
        ResponseDto responseDto = new ResponseDto("User find by Id:", userService.getByUserId(userId));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }


}
