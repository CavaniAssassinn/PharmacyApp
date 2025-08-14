package za.ac.cput.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Order;

public interface OrderRepositoty extends JpaRepository<Order, Long> {
    // List<Order> findByStatus(String status);
    // Or any other custom query methods based on your requirements
    // List<Order> findByCustomerId(Long customerId);
    //  List<Order> findByDateBetween(LocalDate startDate, LocalDate endDate);

}
