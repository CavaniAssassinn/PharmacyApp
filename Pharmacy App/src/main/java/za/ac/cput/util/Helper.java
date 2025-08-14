package za.ac.cput.util;

import za.ac.cput.domain.CartItem;
import java.util.List;
import java.util.regex.Pattern;

public class Helper {

    // Regex for validating email addresses (simple but effective)
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    // Regex for phone number: exactly 10 digits
    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^\\d{10}$");

    /**
     * Checks if a string is null or empty after trimming.
     */
    public static boolean isNullOrEmpty(String str) {
        return (str == null || str.trim().isEmpty());
    }

    /**
     * Validates that an email address matches the pattern.
     */
    public static boolean isValidEmail(String email) {
        return (email != null && EMAIL_PATTERN.matcher(email).matches());
    }

    /**
     * Validates that a phone number is exactly 10 digits.
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return (phoneNumber != null && PHONE_PATTERN.matcher(phoneNumber).matches());
    }

    /**
     * Checks that a required object is not null.
     * Throws an IllegalArgumentException if null.
     */
    public static void checkObjectNotNull(Object obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Checks that a list of cart items is not null or empty.
     */
    public static void validateCartItems(List<CartItem> cartItems) {
        if (cartItems == null || cartItems.isEmpty()) {
            throw new IllegalArgumentException("Cart items cannot be null or empty.");
        }
    }
}

