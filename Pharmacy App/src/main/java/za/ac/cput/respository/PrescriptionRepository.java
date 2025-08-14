package za.ac.cput.respository;


import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Prescription;

public interface PrescriptionRepository extends JpaRepository <Prescription, Long> {
    // This interface will automatically provide CRUD operations for Prescription entities
    // Additional custom query methods can be defined here if needed
    // For example, you can add methods like:
    // List<Prescription> findByPatientId(Long patientId);

}
