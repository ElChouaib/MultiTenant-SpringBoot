package com.example.demo.order;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    private UserRepository userRepository;

    public Order create(OrderDto orderDto) {
        User userOrder = userRepository.findById(orderDto.getUserId()).orElseThrow(EntityNotFoundException::new);
        Order order = Order.builder()
                .name(orderDto.getName())
                .user(userOrder)
                .build();
        return orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order updateById(int id, OrderDto orderDto) {
        Order order = orderRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        System.out.println(orderDto.toString());
        User newUser = userRepository.findById(orderDto.getUserId()).orElseThrow(EntityNotFoundException::new);
        order.setName(orderDto.getName());
        order.setUser(newUser);
        return orderRepository.save(order);
    }

    @Transactional
    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }

    public Order getOrderById(int id) {
        return orderRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}