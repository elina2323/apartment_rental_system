package kg.project.apartment_rental_system.service.imp;

import kg.project.apartment_rental_system.dao.PaymentHistoryRepo;
import kg.project.apartment_rental_system.exception.ResourceNotFoundException;
import kg.project.apartment_rental_system.mapper.PaymentHistoryMapper;
import kg.project.apartment_rental_system.mapper.PropertyMapper;
import kg.project.apartment_rental_system.model.dto.PaymentHistoryDTO;
import kg.project.apartment_rental_system.model.dto.ReserveHistoryDTO;
import kg.project.apartment_rental_system.model.dto.UserDTO;
import kg.project.apartment_rental_system.model.entity.PaymentHistory;
import kg.project.apartment_rental_system.model.entity.Property;
import kg.project.apartment_rental_system.model.enums.ReserveStatus;
import kg.project.apartment_rental_system.service.PaymentHistoryService;
import kg.project.apartment_rental_system.service.PropertyService;
import kg.project.apartment_rental_system.service.ReserveHistoryService;
import kg.project.apartment_rental_system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PaymentHistoryServiceImpl implements PaymentHistoryService {

    private final PaymentHistoryRepo paymentHistoryRepo;

    private ReserveHistoryService reserveHistoryService;

    private UserService userService;

    private PropertyService propertyService;

    @Autowired
    public PaymentHistoryServiceImpl(PaymentHistoryRepo paymentHistoryRepo, ReserveHistoryService reserveHistoryService, UserService userService, PropertyService propertyService) {
        this.paymentHistoryRepo = paymentHistoryRepo;
        this.reserveHistoryService = reserveHistoryService;
        this.userService = userService;
        this.propertyService = propertyService;
    }

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
    public PaymentHistoryDTO findByReserveHistory_Id(Long reserveId) {

        log.info("IN PaymentHistoryServiceImpl findByReserveHistory_Id {}", reserveId);

        PaymentHistory paymentHistory = paymentHistoryRepo.findByReserveHistory_Id(reserveId);
        return PaymentHistoryMapper.INSTANCE.toPaymentHistoryDTO(paymentHistory);
    }

    @Override
    public PaymentHistoryDTO savePayment(Long clientId, Long reserveId, double cash) {

        if (cash <= 0){
            throw new RuntimeException("Неправильно внесена сумма");
        }

        PaymentHistoryDTO paymentHistoryDTO = new PaymentHistoryDTO();
        ReserveHistoryDTO reserveHistoryDTO = reserveHistoryService.findById(reserveId);
        ReserveStatus reserveStatus = reserveHistoryDTO.getReserveStatus();
        if (reserveStatus.equals(ReserveStatus.RESERVED)){
            paymentHistoryDTO.setCash(paymentHistoryDTO.getCash());
        }
        if (paymentHistoryDTO.getCash() >= reserveHistoryDTO.getTotalPrice()){
            reserveHistoryDTO.setReserveStatus(ReserveStatus.PAID);
            reserveHistoryDTO.setTotalPrice(paymentHistoryDTO.getCash() - reserveHistoryDTO.getTotalPrice());
        }else if (paymentHistoryDTO.getCash() < reserveHistoryDTO.getTotalPrice()){
            reserveHistoryDTO.setReserveStatus(ReserveStatus.DEBT);
            reserveHistoryDTO.setDebt(reserveHistoryDTO.getTotalPrice() - paymentHistoryDTO.getCash());
        }else if (){

        }

        PaymentHistory paymentHistory = PaymentHistoryMapper.INSTANCE.toPaymentHistory(paymentHistoryDTO);
        paymentHistory = paymentHistoryRepo.save(paymentHistory);
        return PaymentHistoryMapper.INSTANCE.toPaymentHistoryDTO(paymentHistory);
    }

}
