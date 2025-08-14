package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.domain.Customer;

import java.util.List;

public class CartFactory {

    public static Cart createCart(Customer customer, List<CartItem> cartItems) {
        // Validate customer
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }

        // Validate cart items
        if (cartItems == null || cartItems.isEmpty()) {
            throw new IllegalArgumentException("Cart must contain at least one CartItem.");
        }

        // Create and return the Cart
        return new Cart.Builder()
                .setCustomer(customer)
                .setCartItems(cartItems)
                .build();
    }
}

