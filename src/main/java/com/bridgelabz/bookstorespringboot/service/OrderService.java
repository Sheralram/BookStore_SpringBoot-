package com.bridgelabz.bookstorespringboot.service;

import com.bridgelabz.bookstorespringboot.dto.OrderDto;
import com.bridgelabz.bookstorespringboot.exception.CustomException;
import com.bridgelabz.bookstorespringboot.model.Cart;
import com.bridgelabz.bookstorespringboot.model.Order;
import com.bridgelabz.bookstorespringboot.repository.CartRepository;
import com.bridgelabz.bookstorespringboot.repository.OrderRepository;
import com.bridgelabz.bookstorespringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartService cartService;

    public Order placeOrder(OrderDto orderDto) {
        Optional<Cart> cart = cartRepository.findById(orderDto.cartId);
        if (cart.isPresent()) {
            Order order = new Order(cart.get(), orderDto.getQuantity(), orderDto.getTotalPrice(), orderDto.getAddress());
            orderRepository.save(order);
            return order;
        } else {
            throw new CustomException("Cart Id is not Present");
        }
    }

    public List<Order> getListOrder() {
        return orderRepository.findAll();
    }
}
