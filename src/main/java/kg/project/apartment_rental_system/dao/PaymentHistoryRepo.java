package kg.project.apartment_rental_system.dao;

import kg.project.apartment_rental_system.model.dto.PaymentHistoryDTO;
import kg.project.apartment_rental_system.model.dto.frontside.output.PaymentOutput;
import kg.project.apartment_rental_system.model.dto.frontside.output.ReserveOutput;
import kg.project.apartment_rental_system.model.entity.PaymentHistory;
import kg.project.apartment_rental_system.model.enums.ReserveStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentHistoryRepo extends JpaRepository<PaymentHistory,Long> {

    PaymentHistory findByReserveHistory_Id(Long reserveId);

    PaymentHistory findByReserveHistory_ReserveStatus(ReserveStatus reserveHistory_reserveStatus);

}
