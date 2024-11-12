package com.kodilla.kodillajms.receiver;

import com.kodilla.kodillajms.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderReceiver {

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "order-queue", containerFactory = "jmsFactory")
    public void receiveOrder(Order order) {
        System.out.println("Received Order:");
        System.out.println("ID: " + order.getId());
        System.out.println("Product: " + order.getProduct());
        System.out.println("Quantity: " + order.getQuantity());

        System.out.println("Processing order...");

        jmsTemplate.convertAndSend("processed-order-queue", order);
        System.out.println("Order sent to processed-order-queue");
    }
}
