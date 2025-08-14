/*
 * Medication.java
 * Author: Bruneez Apollis
 * Student Number:
 * Date: 05/08/2025
 */

package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicationId;

    @OneToMany(mappedBy = "medication", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems;


    @Column(nullable = false)
    private String name;

    @Column(length = 2000)
    private String description;

    @Column(nullable = false)
    private String dosage;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int stockQuantity;

    @Column(nullable = false)
    private boolean prescriptionRequired;

    // Default constructor for JPA
    protected Medication() {}

    // Private constructor for Builder
    private Medication(Builder builder) {
        this.medicationId = builder.medicationId;
        this.name = builder.name;
        this.description = builder.description;
        this.dosage = builder.dosage;
        this.price = builder.price;
        this.stockQuantity = builder.stockQuantity;
        this.prescriptionRequired = builder.prescriptionRequired;
    }

    // Getters
    public Long getMedicationId() { return medicationId; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getDosage() { return dosage; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
    public boolean isPrescriptionRequired() { return prescriptionRequired; }

    @Override
    public String toString() {
        return "Medication{" +
                "medicationId=" + medicationId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dosage='" + dosage + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", prescriptionRequired=" + prescriptionRequired +
                '}';
    }

    // Builder class
    public static class Builder {
        private Long medicationId;
        private String name;
        private String description;
        private String dosage;
        private double price;
        private int stockQuantity;
        private boolean prescriptionRequired;

        public Builder setMedicationId(Long medicationId) {
            this.medicationId = medicationId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setDosage(String dosage) {
            this.dosage = dosage;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setStockQuantity(int stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }

        public Builder setPrescriptionRequired(boolean prescriptionRequired) {
            this.prescriptionRequired = prescriptionRequired;
            return this;
        }

        public Builder copy(Medication medication) {
            this.medicationId = medication.medicationId;
            this.name = medication.name;
            this.description = medication.description;
            this.dosage = medication.dosage;
            this.price = medication.price;
            this.stockQuantity = medication.stockQuantity;
            this.prescriptionRequired = medication.prescriptionRequired;
            return this;
        }

        public Medication build() {
            return new Medication(this);
        }
    }
}
