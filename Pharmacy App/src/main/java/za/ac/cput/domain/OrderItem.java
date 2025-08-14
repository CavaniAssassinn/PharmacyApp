package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order; // Each order item belongs to one order

    @ManyToOne
    @JoinColumn(name = "medication_id", nullable = false)
    private Medication medication; // The medication purchased

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double priceAtPurchase; // Price at the time of order

    protected OrderItem() {}

    private OrderItem(Builder builder) {
        this.orderItemId = builder.orderItemId;
        this.order = builder.order;
        this.medication = builder.medication;
        this.quantity = builder.quantity;
        this.priceAtPurchase = builder.priceAtPurchase;
    }

    public Long getOrderItemId() { return orderItemId; }
    public Order getOrder() { return order; }
    public Medication getMedication() { return medication; }
    public int getQuantity() { return quantity; }
    public double getPriceAtPurchase() { return priceAtPurchase; }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId=" + orderItemId +
                ", medication=" + (medication != null ? medication.getName() : null) +
                ", quantity=" + quantity +
                ", priceAtPurchase=" + priceAtPurchase +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem that = (OrderItem) o;
        return Objects.equals(orderItemId, that.orderItemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderItemId);
    }

    public static class Builder {
        private Long orderItemId;
        private Order order;
        private Medication medication;
        private int quantity;
        private double priceAtPurchase;

        public Builder setOrderItemId(Long orderItemId) { this.orderItemId = orderItemId; return this; }
        public Builder setOrder(Order order) { this.order = order; return this; }
        public Builder setMedication(Medication medication) { this.medication = medication; return this; }
        public Builder setQuantity(int quantity) { this.quantity = quantity; return this; }
        public Builder setPriceAtPurchase(double priceAtPurchase) { this.priceAtPurchase = priceAtPurchase; return this; }

        public Builder copy(OrderItem orderItem) {
            this.orderItemId = orderItem.orderItemId;
            this.order = orderItem.order;
            this.medication = orderItem.medication;
            this.quantity = orderItem.quantity;
            this.priceAtPurchase = orderItem.priceAtPurchase;
            return this;
        }

        public OrderItem build() { return new OrderItem(this); }
    }
}

