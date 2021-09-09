package kg.project.apartment_rental_system.service.imp;

import kg.project.apartment_rental_system.dao.PaymentHistoryRepo;
import kg.project.apartment_rental_system.exception.ResourceNotFoundException;
import kg.project.apartment_rental_system.mapper.PaymentHistoryMapper;
import kg.project.apartment_rental_system.model.dto.PaymentHistoryDTO;
import kg.project.apartment_rental_system.model.entity.PaymentHistory;
import kg.project.apartment_rental_system.service.PaymentHistoryService;
import kg.project.apartment_rental_system.service.PropertyService;
import kg.project.apartment_rental_system.service.ReserveHistoryService;
import kg.project.apartment_rental_system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PaymentHistoryServiceImpl implements PaymentHistoryService {

    @Autowired
    private PaymentHistoryRepo paymentHistoryRepo;

    @Autowired
    private ReserveHistoryService reserveHistoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private PropertyService propertyService;


    @Override
    public PaymentHistoryDTO save(PaymentHistoryDTO paymentHistoryDTO) {

        log.info("IN PaymentHistoryServiceImpl save {}", paymentHistoryDTO);
        PaymentHistory paymentHistory = PaymentHistoryMapper.INSTANCE.toPaymentHistory(paymentHistoryDTO);
        paymentHistory = paymentHistoryRepo.save(paymentHistory);
        return PaymentHistoryMapper.INSTANCE.toPaymentHistoryDTO(paymentHistory);
    }

    @Override
    public PaymentHistoryDTO update(PaymentHistoryDTO paymentHistoryDTO) {
        return null;
    }

    @Override
    public void removeByID(Long id) {

    }

    @Override
    public PaymentHistoryDTO findById(Long id) throws ResourceNotFoundException {
        log.info("IN PaymentHistoryServiceImpl findById {}", id);
        PaymentHistory paymentHistory = paymentHistoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("История оплаты с таким id \"%s\" не найдена" + id));
        return PaymentHistoryMapper.INSTANCE.toPaymentHistoryDTO(paymentHistory);
    }

    @Override
    public List<PaymentHistoryDTO> findAll() {
        return null;
    }

    @Override
    public List<PaymentHistoryDTO> findByReserveHistoryId(Long reserveId) {

        log.info("IN PaymentHistoryServiceImpl findByReserveHistory_Id {}", reserveId);

        return PaymentHistoryMapper.INSTANCE.toPaymentHistoryDTOList(paymentHistoryRepo.findByReserveHistoryId(reserveId));
    }



}
