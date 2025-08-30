/*
 * Matthew Michael Engelbrecht
 * Student Number: 222381086
 * */
package za.ac.cput.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Pharmacist;

public interface PharmacistRepository extends JpaRepository<Pharmacist, Long> {
    // Additional query methods can be defined here if needed
    Pharmacist findByLicenseNumber(String licenseNumber);

    Pharmacist findByEmail(String email);
}
