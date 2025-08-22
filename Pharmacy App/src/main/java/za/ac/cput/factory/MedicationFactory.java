package za.ac.cput.factory;

import za.ac.cput.domain.Medication;
import za.ac.cput.util.Helper;

public class MedicationFactory {

    public static Medication createMedication(
            String name,
            String description,
            String dosage,
            double price,
            int stockQuantity,
            boolean prescriptionRequired) {

        // Validate required fields
        if (Helper.isNullOrEmpty(name))
            throw new IllegalArgumentException("Medication name is required.");

        if (Helper.isNullOrEmpty(dosage))
            throw new IllegalArgumentException("Dosage information is required.");

        if (price <= 0)
            throw new IllegalArgumentException("Price must be greater than zero.");

        if (stockQuantity < 0)
            throw new IllegalArgumentException("Stock quantity cannot be negative.");

        // Optional: description can be empty, but trim it to avoid null issues
        if (description == null)
            description = "";

        return new Medication.Builder()
                .setName(name.trim())
                .setDescription(description.trim())
                .setDosage(dosage.trim())
                .setPrice(price)
                .setStockQuantity(stockQuantity)
                .setPrescriptionRequired(prescriptionRequired)
                .build();
    }
}

