package za.ac.cput.factory;

import za.ac.cput.domain.Pharmacist;
import za.ac.cput.util.Helper;

public class PharmacistFactory {

    public static Pharmacist createPharmacist(
            String userId,
            String firstName,
            String lastName,
            String email,
            String password,
            String licenseNumber
    ) {
        // Validate required fields
        if (Helper.isNullOrEmpty(userId) || Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName)
                || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password)
                || Helper.isNullOrEmpty(licenseNumber)) {
            throw new IllegalArgumentException("One or more required fields are null or empty.");
        }

        // Validate email format
        if (!Helper.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format.");
        }


        // Build and return Pharmacist
        return new Pharmacist.Builder()
                .setUserId(userId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setLicenseNumber(licenseNumber)
                .build();
    }
}

