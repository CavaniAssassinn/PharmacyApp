/*
 * Cart.java
 * Author: Bruneez Apollis
 * Student Number:
 * Date: 05/08/2025
 */

package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false, unique = true)
    private Customer customer; // Each cart belongs to exactly one customer

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems; // One cart can have many items


    // Protected default constructor for JPA
    protected Cart() {}

    // Builder constructor
    private Cart(Builder builder) {
        this.cartId = builder.cartId;
        this.customer = builder.customer;
        this.cartItems = builder.cartItems;
    }

    // Getters
    public Long getCartId() {
        return cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", customerId=" + (customer != null ? customer.getUserId() : null) +
                ", cartItems=" + (cartItems != null ? cartItems.size() : 0) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;
        Cart cart = (Cart) o;
        return Objects.equals(cartId, cart.cartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId);
    }

    // Builder Pattern
    public static class Builder {
        private Long cartId;
        private Customer customer;
        private List<CartItem> cartItems;

        public Builder setCartId(Long cartId) {
            this.cartId = cartId;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder setCartItems(List<CartItem> cartItems) {
            this.cartItems = cartItems;
            return this;
        }

        public Builder copy(Cart cart) {
            this.cartId = cart.cartId;
            this.customer = cart.customer;
            this.cartItems = cart.cartItems;
            return this;
        }

        public Cart build() {
            return new Cart(this);
        }
    }
}

