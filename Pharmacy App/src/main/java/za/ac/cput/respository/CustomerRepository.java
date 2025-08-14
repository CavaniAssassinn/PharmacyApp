package za.ac.cput.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmail(String email);
    Customer findByPhoneNumber(String phoneNumber);

}
