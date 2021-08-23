package kg.project.apartment_rental_system.dao;

import kg.project.apartment_rental_system.model.dto.PaymentHistoryDTO;
import kg.project.apartment_rental_system.model.entity.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentHistoryRepo extends JpaRepository<PaymentHistory,Long> {

    public List<PaymentHistoryDTO> findByReserveHistoryId(Long reserve_id);
}
