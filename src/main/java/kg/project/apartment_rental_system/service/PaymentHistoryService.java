package kg.project.apartment_rental_system.service;

import kg.project.apartment_rental_system.model.dto.PaymentHistoryDTO;
import kg.project.apartment_rental_system.model.entity.PaymentHistory;
import kg.project.apartment_rental_system.service.base.BaseService;

import java.util.List;

public interface PaymentHistoryService extends BaseService<PaymentHistoryDTO, Long> {

    PaymentHistoryDTO findByReserveHistory_Id(Long reserveId);

    PaymentHistoryDTO savePayment(Long clientId, Long reserveId, double cash);
}
