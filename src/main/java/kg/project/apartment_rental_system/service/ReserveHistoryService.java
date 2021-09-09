package kg.project.apartment_rental_system.service;

import kg.project.apartment_rental_system.model.dto.ReserveHistoryDTO;
import kg.project.apartment_rental_system.model.dto.frontside.input.ReserveHistoryInput;
import kg.project.apartment_rental_system.model.dto.frontside.output.PaymentOutput;
import kg.project.apartment_rental_system.model.dto.frontside.output.ReserveOutput;
import kg.project.apartment_rental_system.service.base.BaseService;
import org.springframework.http.ResponseEntity;

public interface ReserveHistoryService extends BaseService<ReserveHistoryDTO, Long> {

    ResponseEntity<ReserveHistoryDTO> saveReservation(ReserveHistoryInput reserveHistoryInput) throws Exception;

    ResponseEntity<ReserveOutput> executePayment(Long clientId, Long reserveId, double cash) throws Exception;

    ResponseEntity<PaymentOutput> refund(Long paymentId, Long reserveId, Long clientId) throws Exception;


}
