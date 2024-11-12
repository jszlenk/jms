package com.kodilla.kodillajms.controller;

import com.kodilla.kodillajms.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/process")
    public String processOrder(@RequestBody Order order) {
        jmsTemplate.convertAndSend("order-queue", order);
        return "Order sent to JMS queue";
    }
}
