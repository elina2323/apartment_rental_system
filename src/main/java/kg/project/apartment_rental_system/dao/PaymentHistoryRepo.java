package kg.project.apartment_rental_system.dao;

import kg.project.apartment_rental_system.model.dto.PaymentHistoryDTO;
import kg.project.apartment_rental_system.model.dto.frontside.output.PaymentOutput;
import kg.project.apartment_rental_system.model.dto.frontside.output.ReserveOutput;
import kg.project.apartment_rental_system.model.entity.PaymentHistory;
import kg.project.apartment_rental_system.model.entity.ReserveHistory;
import kg.project.apartment_rental_system.model.enums.ReserveStatus;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentHistoryRepo extends JpaRepository<PaymentHistory,Long> {

    List<PaymentHistory> findByReserveHistoryId(Long reserveId);

    List<PaymentHistory> findByReserveHistoryIdAndCash(Long reserveHistory_id, @NonNull double cash);

}
