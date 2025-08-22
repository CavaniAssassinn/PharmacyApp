/*
 * Pharmacist.java
 * Author: Bruneez Apollis
 * Student Number:
 * Date: 05/08/2025
 */

package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class Pharmacist extends User {

    @Column(nullable = false, unique = true)
    private String licenseNumber;

    // Protected default constructor for JPA
    protected Pharmacist() {}

    // Builder constructor
    private Pharmacist(Builder builder) {
        super(builder); // calls User's builder constructor
        this.licenseNumber = builder.licenseNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    @Override
    public String toString() {
        return "Pharmacist{" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                '}';
    }

    // Pharmacist Builder
    public static class Builder extends User.Builder<Builder> {
        private String licenseNumber;

        public Builder() {
            this.setRole(Role.PHARMACIST); // Always set role as pharmacist
        }

        public Builder setLicenseNumber(String licenseNumber) {
            this.licenseNumber = licenseNumber;
            return this;
        }

        public Builder copy(Pharmacist pharmacist) {
            this.setUserId(pharmacist.getUserId())
                    .setFirstName(pharmacist.getFirstName())
                    .setLastName(pharmacist.getLastName())
                    .setEmail(pharmacist.getEmail())
                    .setPassword(pharmacist.getPassword())
                    .setLicenseNumber(pharmacist.getLicenseNumber());
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Pharmacist build() {
            return new Pharmacist(this);
        }
    }
}
