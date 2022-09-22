package com.bridgelabz.bookstorespringboot.controller;


import com.bridgelabz.bookstorespringboot.dto.AddressDetailsDto;
import com.bridgelabz.bookstorespringboot.dto.ResponseDto;
import com.bridgelabz.bookstorespringboot.service.AddressDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/address")
@RestController
public class AddressDetailsController {

    @Autowired
    AddressDetailsService service;

    @PostMapping("/addAddress")
    public ResponseEntity<ResponseDto> addAddress( @RequestBody AddressDetailsDto dto) {
        ResponseDto responseDto = new ResponseDto("Book:", service.add(dto) );
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

//    @GetMapping("/type/")
//    public ResponseEntity<ResponseDto> getTypeByHome(@PathVariable String type) {
//        ResponseDto responseDto = new ResponseDto("Type Home is found", service.getByType(type));
//        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
//    }



}
