package com.bridgelabz.bookstorespringboot.service;

import com.bridgelabz.bookstorespringboot.dto.CartDto;
import com.bridgelabz.bookstorespringboot.exception.CustomException;
import com.bridgelabz.bookstorespringboot.model.BookEntity;
import com.bridgelabz.bookstorespringboot.model.Cart;
import com.bridgelabz.bookstorespringboot.model.User;
import com.bridgelabz.bookstorespringboot.repository.BookRepository;
import com.bridgelabz.bookstorespringboot.repository.CartRepository;
import com.bridgelabz.bookstorespringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;



    public Object addToCart(CartDto cartDTO) {
        Optional<User> userData = userRepository.findById(cartDTO.getUser_Id());
        Optional<BookEntity> bookData = Optional.ofNullable(bookService.getById(cartDTO.getBookId()));
        if (userData.isPresent() && bookData.isPresent()) {
            if(bookData.get().getQuantity() >= cartDTO.getQuantity() && cartDTO.getQuantity() > 0 )
            {
                Cart cart = cartRepository.findCartsByUserIdAndBookId(cartDTO.getBookId(), userData.get().getUserId());
                if (cart != null) {
                    Cart cartDetails = update(cartDTO, cart.getCartId());
                    return cartDetails;
                } else {
                    double totalPrice = cartDTO.getQuantity() * bookData.get().getPrice();
                    Cart cartDetails = new Cart(userData.get(), bookData.get(), cartDTO.getQuantity(), totalPrice);
                    return cartRepository.save(cartDetails);
                }
            }
            throw (new CustomException("Book Out Of Stock"));
        }
        throw (new CustomException("Record not Found"));
    }

    public Cart update(CartDto cartDTO, long id) {
        User userData = userService.getByUserId((cartDTO.getUser_Id()));
      if (cartRepository.findById(id).isPresent() && userData != null) {
            Cart cart = cartRepository.findById(id).get();
            cart.setQuantity(cartDTO.quantity);
            cart.setTotalPrice(cart.getQuantity() * cart.getBook().getPrice());
            return cartRepository.save(cart);
        } else throw new CustomException("No book found with the given id or you are not an admin user..");

    }

    public Cart updateQuantity(long cartId, int quantity, double totalPrice ) {

        if (cartRepository.findById(cartId).isPresent()){
            Cart cart = cartRepository.findById(cartId).get();
            cart.setQuantity(quantity);
            cart.setTotalPrice(cart.getQuantity() * cart.getBook().getPrice());
            return cartRepository.save(cart);
        } else throw new CustomException("No book found with the given id or you are not an admin user..");
    }

    public List<Cart> getCartItems(long id) {
        return  cartRepository.findCartsByUserId(id);
    }

    public Object removeById(Long id) {
        Optional<Cart> cart = cartRepository.findById(id);
        if (cart.isPresent()){
            cartRepository.delete(cart.get());
            return "Record is deleted with id ";
        }
        throw (new CustomException("Record not Found"));
    }
    public String emptyCart() {
        cartRepository.deleteAll();
        return "All Cart Item Deleted";
    }





}
