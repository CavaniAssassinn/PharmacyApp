package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;
import za.ac.cput.util.Helper;

public class CustomerFactory {

    public static Customer createCustomer(
            String userId,
            String firstName,
            String lastName,
            String email,
            String password,
            Address address,
            String phoneNumber
    ) {
        // Basic validations
        if (Helper.isNullOrEmpty(userId) || Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName)
                || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password)
                || address == null || Helper.isNullOrEmpty(phoneNumber)) {
            throw new IllegalArgumentException("One or more required fields are null or empty.");
        }

        // Email validation
        if (!Helper.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format.");
        }

        // Phone number validation
        if (!Helper.isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number format.");
        }

        // Build and return Customer
        return new Customer.Builder()
                .setUserId(userId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setAddress(address)
                .setPhoneNumber(phoneNumber)
                .build();
    }
}
