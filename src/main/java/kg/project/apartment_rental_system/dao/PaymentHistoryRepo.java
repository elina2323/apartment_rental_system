package kg.project.apartment_rental_system.dao;

import kg.project.apartment_rental_system.model.entity.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentHistoryRepo extends JpaRepository<PaymentHistory,Long> {
}
