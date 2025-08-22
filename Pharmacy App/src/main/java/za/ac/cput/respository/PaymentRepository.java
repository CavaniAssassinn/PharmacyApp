package za.ac.cput.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // add methods like:
    // List<Payment> findByUserId(Long userId);
}
