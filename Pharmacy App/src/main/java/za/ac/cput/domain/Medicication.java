package main.java.za.ac.cput.domain;

public class Medicication {
    private int medicationID;
    private String name;
    private String description;
    private String dosage;
    private double price;
    private int stockQuantity;

    private boolean prescriptionRequired;


    private Medicication(MedicicationBuilder builder) {
        this.medicationID = builder.medicationID;
        this.name = builder.name;
        this.description = builder.description;
        this.dosage = builder.dosage;
        this.price = builder.price;
        this.stockQuantity = builder.stockQuantity;
        this.prescriptionRequired = builder.prescriptionRequired;
    }

    public int getMedicationID() {
        return medicationID;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getDosage() {
        return dosage;
    }
    public double getPrice() {
        return price;
    }
    public int getStockQuantity() {
        return stockQuantity;
    }
    public boolean isPrescriptionRequired() {
        return prescriptionRequired;
    }

    @Override
    public String toString() {
        return "Medicication{" +
                "medicationID=" + medicationID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dosage='" + dosage + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", prescriptionRequired=" + prescriptionRequired +
                '}';
    }
    public static class MedicicationBuilder {
        private int medicationID;
        private String name;
        private String description;
        private String dosage;
        private double price;
        private int stockQuantity;
        private boolean prescriptionRequired;

        public MedicicationBuilder setMedicationID(int medicationID) {
            this.medicationID = medicationID;
            return this;
        }

        public MedicicationBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public MedicicationBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public MedicicationBuilder setDosage(String dosage) {
            this.dosage = dosage;
            return this;
        }

        public MedicicationBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public MedicicationBuilder setStockQuantity(int stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }

        public MedicicationBuilder setPrescriptionRequired(boolean prescriptionRequired) {
            this.prescriptionRequired = prescriptionRequired;
            return this;
        }

        public Medicication build() {
            return new Medicication(this);
        }
    }
}
