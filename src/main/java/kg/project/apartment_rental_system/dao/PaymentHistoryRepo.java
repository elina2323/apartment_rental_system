package kg.project.apartment_rental_system.dao;

import kg.project.apartment_rental_system.model.entity.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentHistoryRepo extends JpaRepository<PaymentHistory,Long> {

    List<PaymentHistory> findByReserveHistoryId(Long reserveId);

    List<PaymentHistory> findPaymentHistoryByIdIsAndReserveHistoryId(Long id, Long reserveHistory_id);
}
