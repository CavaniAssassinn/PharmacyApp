package za.ac.cput.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
    // Additional query methods can be defined here if needed

    Cart findByUserId(Long userId);

}
