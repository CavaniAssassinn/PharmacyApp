/*
 * Customer.java
 * Author: Bruneez Apollis
 * Student Number:
 * Date: 05/08/2025
 */

package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Customer extends User {

    @Embedded
    private Address address;

    @Column(nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Cart cart;

    // Protected default constructor for JPA
    protected Customer() {}

    // Builder constructor
    private Customer(Builder builder) {
        super(builder); // calls User's builder constructor
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
    }

    // Getters
    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Cart getCart() {
        return cart;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address +
                '}';
    }

    // Builder for Customer
    public static class Builder extends User.Builder<Builder> {
        private Address address;
        private String phoneNumber;

        public Builder() {
            this.setRole(Role.CUSTOMER); // ensures role is always CUSTOMER
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder copy(Customer customer) {
            this.setUserId(customer.getUserId())
                    .setFirstName(customer.getFirstName())
                    .setLastName(customer.getLastName())
                    .setEmail(customer.getEmail())
                    .setPassword(customer.getPassword())
                    .setAddress(customer.getAddress())
                    .setPhoneNumber(customer.getPhoneNumber());
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Customer build() {
            return new Customer(this);
        }
    }
}
