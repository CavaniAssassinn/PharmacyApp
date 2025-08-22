package za.ac.cput.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders") // Avoid reserved keyword "order"
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private LocalDateTime orderDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer; // Many orders per customer

    @OneToOne
    @JoinColumn(name = "cart_id", nullable = false, unique = true)
    private Cart cart; // One cart per order

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems; // One order can have many order items

    protected Order() {}

    private Order(Builder builder) {
        this.orderId = builder.orderId;
        this.orderDate = builder.orderDate;
        this.status = builder.status;
        this.customer = builder.customer;
        this.cart = builder.cart;
        this.orderItems = builder.orderItems;
    }

    public Long getOrderId() { return orderId; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public String getStatus() { return status; }
    public Customer getCustomer() { return customer; }
    public Cart getCart() { return cart; }
    public List<OrderItem> getOrderItems() { return orderItems; }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", customerId=" + (customer != null ? customer.getUserId() : null) +
                ", cartId=" + (cart != null ? cart.getCartId() : null) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    public static class Builder {
        private Long orderId;
        private LocalDateTime orderDate;
        private String status;
        private Customer customer;
        private Cart cart;
        private List<OrderItem> orderItems;

        public Builder setOrderId(Long orderId) { this.orderId = orderId; return this; }
        public Builder setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; return this; }
        public Builder setStatus(String status) { this.status = status; return this; }
        public Builder setCustomer(Customer customer) { this.customer = customer; return this; }
        public Builder setCart(Cart cart) { this.cart = cart; return this; }
        public Builder setOrderItems(List<OrderItem> orderItems) { this.orderItems = orderItems; return this; }

        public Builder copy(Order order) {
            this.orderId = order.orderId;
            this.orderDate = order.orderDate;
            this.status = order.status;
            this.customer = order.customer;
            this.cart = order.cart;
            this.orderItems = order.orderItems;
            return this;
        }

        public Order build() { return new Order(this); }
    }
}
