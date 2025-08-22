package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @ManyToOne(optional = false)
    @JoinColumn(name = "medication_id", nullable = false)
    private Medication medication;

    @Column(nullable = false)
    private int quantity;

    protected CartItem() {}

    public CartItem(Cart cart, Medication medication, int quantity) {
        this.cart = cart;
        this.medication = medication;
        this.quantity = quantity;
    }

    // Getters & setters
    public Long getId() { return id; }
    public Cart getCart() { return cart; }
    public Medication getMedication() { return medication; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}

