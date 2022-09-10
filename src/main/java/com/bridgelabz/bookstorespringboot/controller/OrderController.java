package com.bridgelabz.bookstorespringboot.controller;

import com.bridgelabz.bookstorespringboot.dto.OrderDto;
import com.bridgelabz.bookstorespringboot.dto.ResponseDto;
import com.bridgelabz.bookstorespringboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<ResponseDto> placeOrder(@RequestBody OrderDto orderDto){
        ResponseDto responseDto = new ResponseDto("Order Added Successfully", orderService.placeOrder(orderDto));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/listOrder")
    public ResponseEntity<ResponseDto> getAllOrder(){
        ResponseDto responseDto = new ResponseDto("List Orders:" , orderService.getListOrder());
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }


}
