package za.ac.cput.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Medication;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
 //find medications by name:
    // List<Medication> findByName(String name);

    // Or to find medications by dosage:
    // List<Medication> findByDosage(String dosage);

}
