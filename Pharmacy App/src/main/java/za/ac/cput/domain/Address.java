/*
 * Address.java
 * Author: Bruneez Apollis
 * Student Number:
 * Date: 05/08/2025
 */

package za.ac.cput.domain;

import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {

    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    // Default constructor for JPA
    protected Address() {}

    // Builder constructor
    private Address(Builder builder) {
        this.street = builder.street;
        this.city = builder.city;
        this.state = builder.state;
        this.postalCode = builder.postalCode;
        this.country = builder.country;
    }

    // Getters
    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getPostalCode() { return postalCode; }
    public String getCountry() { return country; }

    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " " + postalCode + ", " + country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) &&
                Objects.equals(city, address.city) &&
                Objects.equals(state, address.state) &&
                Objects.equals(postalCode, address.postalCode) &&
                Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, state, postalCode, country);
    }

    // Builder
    public static class Builder {
        private String street;
        private String city;
        private String state;
        private String postalCode;
        private String country;

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder copy(Address address) {
            this.street = address.street;
            this.city = address.city;
            this.state = address.state;
            this.postalCode = address.postalCode;
            this.country = address.country;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
