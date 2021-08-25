package kg.project.apartment_rental_system.service;

import kg.project.apartment_rental_system.model.dto.ReserveHistoryDTO;
import kg.project.apartment_rental_system.model.dto.frontside.input.ReserveHistoryInput;
import kg.project.apartment_rental_system.model.dto.frontside.output.ReserveOutput;
import kg.project.apartment_rental_system.service.base.BaseService;

public interface ReserveHistoryService extends BaseService<ReserveHistoryDTO, Long> {

    ReserveHistoryDTO saveReservation(ReserveHistoryInput reserveHistoryInput);

//    ReserveOutput savePayment(Long clientId, Long reserveId, double cash);


}
