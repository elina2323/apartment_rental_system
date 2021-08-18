package kg.project.apartment_rental_system.mapper;

import kg.project.apartment_rental_system.model.dto.PaymentHistoryDTO;
import kg.project.apartment_rental_system.model.entity.PaymentHistory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PaymentHistoryMapper {

    PaymentHistoryMapper INSTANCE = Mappers.getMapper(PaymentHistoryMapper.class);

    PaymentHistory toPaymentHistory(PaymentHistoryDTO paymentHistoryDTO);

    PaymentHistoryDTO toPaymentHistoryDTO(PaymentHistory paymentHistory);

    List<PaymentHistory> toPaymentHistoryList(List<PaymentHistoryDTO> paymentHistoryDTOList);

    List<PaymentHistoryDTO> toPaymentHistoryDTOList(List<PaymentHistory> paymentHistoryList);
}
