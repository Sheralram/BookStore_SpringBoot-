package com.bridgelabz.bookstorespringboot.controller;

import com.bridgelabz.bookstorespringboot.dto.CartDto;
import com.bridgelabz.bookstorespringboot.dto.ResponseDto;
import com.bridgelabz.bookstorespringboot.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/add")
        public ResponseEntity<ResponseDto> addToCart(@RequestBody CartDto cartDto) {
        ResponseDto responseDTO = new ResponseDto("Add record  Success", cartService.addToCart(cartDto));
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseDto> getAll(@RequestParam long user_Id){
        ResponseDto respnseDTO = new ResponseDto("Here are all the Cart Items.." , cartService.getCartItems(user_Id));
        return new ResponseEntity<ResponseDto>(respnseDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{cartId}/{quantity}/{totalPrice}")
    public ResponseEntity<ResponseDto> updateQuantity( @PathVariable long cartId,@PathVariable int quantity,@PathVariable double totalPrice){
        ResponseDto responseDTO = new ResponseDto("updating the Quantity and Price",cartService.updateQuantity(cartId,quantity,totalPrice));
        return new ResponseEntity<ResponseDto>(responseDTO,HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{cartId}")
    public ResponseEntity<ResponseDto> updateQuantity( @PathVariable long cartId,@RequestBody CartDto cartDTO){
        System.out.println(cartDTO);
        ResponseDto responseDTO = new ResponseDto("updating  all the cart Items",cartService.update(cartDTO,cartId));
        return new ResponseEntity<ResponseDto>(responseDTO,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/remove/{cartId}")
    public ResponseEntity<ResponseDto> removeFromCart(@PathVariable long cartId){
        ResponseDto responseDTO = new ResponseDto("Here are all the Cart Items..." , cartService.removeById(cartId));
        return new ResponseEntity<ResponseDto>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/empty")
    public ResponseEntity<ResponseDto> emptyCart(){
        ResponseDto responseDTO = new ResponseDto("Deleting all the cart Itmens",cartService.emptyCart());
        return new ResponseEntity<ResponseDto>(responseDTO,HttpStatus.ACCEPTED);
    }



}
