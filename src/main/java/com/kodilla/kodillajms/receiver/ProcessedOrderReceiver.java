package com.kodilla.kodillajms.receiver;

import com.kodilla.kodillajms.model.Order;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ProcessedOrderReceiver {

    @JmsListener(destination = "processed-order-queue", containerFactory = "jmsFactory")
    public void receiveProcessedOrder(Order order) {
        System.out.println("Received Processed Order:");
        System.out.println("ID: " + order.getId());
        System.out.println("Product: " + order.getProduct());
        System.out.println("Quantity: " + order.getQuantity());

        System.out.println("Finalizing order processing...");
    }
}
