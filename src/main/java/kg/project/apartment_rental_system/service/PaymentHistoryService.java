package kg.project.apartment_rental_system.service;

import kg.project.apartment_rental_system.model.dto.PaymentHistoryDTO;
import kg.project.apartment_rental_system.model.entity.PaymentHistory;
import kg.project.apartment_rental_system.service.base.BaseService;
import lombok.NonNull;

import java.util.List;

public interface PaymentHistoryService extends BaseService<PaymentHistoryDTO, Long> {

    List<PaymentHistoryDTO> findByReserveHistoryId(Long reserveId);

    List<PaymentHistoryDTO> findByReserveHistoryIdAndCash(Long reserveHistory_id, @NonNull double cash);

}
