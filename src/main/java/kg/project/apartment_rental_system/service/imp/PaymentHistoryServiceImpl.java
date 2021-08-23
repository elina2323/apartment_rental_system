package kg.project.apartment_rental_system.service.imp;

import kg.project.apartment_rental_system.dao.PaymentHistoryRepo;
import kg.project.apartment_rental_system.exception.ResourceNotFoundException;
import kg.project.apartment_rental_system.mapper.PaymentHistoryMapper;
import kg.project.apartment_rental_system.model.dto.PaymentHistoryDTO;
import kg.project.apartment_rental_system.model.entity.PaymentHistory;
import kg.project.apartment_rental_system.service.PaymentHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PaymentHistoryServiceImpl implements PaymentHistoryService {

    private PaymentHistoryRepo paymentHistoryRepo;

    public PaymentHistoryServiceImpl(PaymentHistoryRepo paymentHistoryRepo) {
        this.paymentHistoryRepo = paymentHistoryRepo;
    }


    @Override
    public PaymentHistoryDTO save(PaymentHistoryDTO paymentHistoryDTO) {
        return null;
    }

    @Override
    public PaymentHistoryDTO update(PaymentHistoryDTO paymentHistoryDTO) {
        return null;
    }

    @Override
    public void removeByID(Long id) {

    }

    @Override
    public PaymentHistoryDTO findById(Long id) {
        return null;
    }

    @Override
    public List<PaymentHistoryDTO> findAll() {
        return null;
    }
}
