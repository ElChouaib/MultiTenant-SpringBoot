package com.example.demo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order create(@RequestBody OrderDto order) {
        return orderService.create(order);
    }

    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable("id") int id) {
        return orderService.getOrderById(id);
    }
    @PatchMapping("/{id}")
    public Order updateById(@PathVariable("id") int id, @RequestBody OrderDto order) {
        return orderService.updateById(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        orderService.deleteById(id);
    }
}