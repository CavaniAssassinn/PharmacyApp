package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;
import java.util.List;

public class OrderFactory {

    public static Order createOrder(
            String status,
            Customer customer,
            Cart cart,
            List<OrderItem> orderItems
    ) {
        // Validate required objects
        if (Helper.isNullOrEmpty(status) || customer == null || cart == null) {
            throw new IllegalArgumentException("Status, customer, and cart cannot be null or empty.");
        }

        // Optional: validate order items list
        if (orderItems == null || orderItems.isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one order item.");
        }

        // Create and return the Order
        return new Order.Builder()
                .setOrderDate(LocalDateTime.now()) // Set current date/time
                .setStatus(status)
                .setCustomer(customer)
                .setCart(cart)
                .setOrderItems(orderItems)
                .build();
    }
}

