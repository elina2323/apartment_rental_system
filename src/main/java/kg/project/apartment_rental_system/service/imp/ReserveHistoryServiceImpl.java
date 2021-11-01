package kg.project.apartment_rental_system.service.imp;

import kg.project.apartment_rental_system.dao.ReserveHistoryRepo;
import kg.project.apartment_rental_system.exception.ResourceNotFoundException;
import kg.project.apartment_rental_system.mapper.ReserveHistoryMapper;
import kg.project.apartment_rental_system.model.dto.PaymentHistoryDTO;
import kg.project.apartment_rental_system.model.dto.PropertyDTO;
import kg.project.apartment_rental_system.model.dto.ReserveHistoryDTO;
import kg.project.apartment_rental_system.model.dto.UserDTO;
import kg.project.apartment_rental_system.model.dto.frontside.input.ReserveHistoryInput;
import kg.project.apartment_rental_system.model.dto.frontside.output.PaymentOutput;
import kg.project.apartment_rental_system.model.dto.frontside.output.ReserveOutput;
import kg.project.apartment_rental_system.model.entity.ReserveHistory;
import kg.project.apartment_rental_system.model.enums.ReserveStatus;
import kg.project.apartment_rental_system.service.PaymentHistoryService;
import kg.project.apartment_rental_system.service.PropertyService;
import kg.project.apartment_rental_system.service.ReserveHistoryService;
import kg.project.apartment_rental_system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class ReserveHistoryServiceImpl implements ReserveHistoryService {

    @Autowired
    private ReserveHistoryRepo reserveHistoryRepo;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private PaymentHistoryService paymentHistoryService;

    @Autowired
    private UserService userService;

    ReserveHistoryMapper reserveHistoryMapper = ReserveHistoryMapper.INSTANCE;


    @Override
    public ReserveHistoryDTO save(ReserveHistoryDTO reserveHistoryDTO) {

        log.info("IN ReserveHistoryServiceImpl save {}", reserveHistoryDTO);
        ReserveHistory reserveHistory = ReserveHistoryMapper.INSTANCE.toReserveHistory(reserveHistoryDTO);
        reserveHistory = reserveHistoryRepo.save(reserveHistory);
        return ReserveHistoryMapper.INSTANCE.toReserveHistoryDTO(reserveHistory);
    }


    @Override
    public ReserveHistoryDTO update(ReserveHistoryDTO reserveHistoryDTO) {
        return null;
    }

    @Override
    public void removeByID(Long id) {

    }

    @Override
    public ReserveHistoryDTO findById(Long id) throws ResourceNotFoundException {
        log.info("IN ReserveHistoryServiceImpl findById {}", id);
        ReserveHistory reserveHistory = reserveHistoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("История оплаты с таким id \"%s\" не найдена" + id));
        return ReserveHistoryMapper.INSTANCE.toReserveHistoryDTO(reserveHistory);
    }

    @Override
    public List<ReserveHistoryDTO> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<ReserveHistoryDTO> saveReservation(ReserveHistoryInput reserveHistoryInput) throws Exception{

        log.info("IN ReserveHistoryServiceImpl saveReservation {}", reserveHistoryInput);

        LocalDate checkInDate = reserveHistoryInput.getCheckInDate();
        LocalDate checkOutDate = reserveHistoryInput.getCheckOutDate();

        List<ReserveHistoryDTO> reserveHistoryDTOList = reserveHistoryMapper.toReserveHistoryDTOList(reserveHistoryRepo.findByPropertyId(reserveHistoryInput.getPropertyId()));
        if (isAvailableBetween(reserveHistoryDTOList, checkInDate, checkOutDate)) {
            throw new RuntimeException("Поставлена бронь на выбранные даты");
        }

        int daysBetween = Math.toIntExact(ChronoUnit.DAYS.between(checkInDate, checkOutDate));

        PropertyDTO propertyDTO = propertyService.findById(reserveHistoryInput.getPropertyId());
        double sum = daysBetween * propertyDTO.getPrice();

        ReserveHistoryDTO reserveHistoryDTO = new ReserveHistoryDTO();
        reserveHistoryDTO.setCheckInDate(reserveHistoryInput.getCheckInDate());
        reserveHistoryDTO.setCheckOutDate(reserveHistoryInput.getCheckOutDate());
        reserveHistoryDTO.setProperty(propertyService.findById(reserveHistoryInput.getPropertyId()));
        reserveHistoryDTO.setUser(userService.findById(reserveHistoryInput.getClientId()));
        reserveHistoryDTO.setTotalPrice(sum);
        reserveHistoryDTO.setReserveStatus(ReserveStatus.RESERVED);

        ReserveHistory reserveHistory = ReserveHistoryMapper.INSTANCE.toReserveHistory(reserveHistoryDTO);
        reserveHistory = reserveHistoryRepo.save(reserveHistory);
        return ResponseEntity.status(HttpStatus.OK).body(ReserveHistoryMapper.INSTANCE.toReserveHistoryDTO(reserveHistory));

    }

    @Override
    public ResponseEntity<ReserveOutput> executePayment(Long clientId, Long reserveId, double cash) throws Exception{

        if (cash <= 0) {
            throw new RuntimeException("Неправильно внесена сумма");
        }

        PaymentHistoryDTO paymentHistoryDTO = new PaymentHistoryDTO();
        ReserveHistoryDTO reserveHistoryDTO = findById(reserveId);
        UserDTO userDTO = userService.findById(clientId);
        reserveHistoryDTO.setUser(userDTO);
        userDTO.setPhone(userDTO.getPhone());
        reserveHistoryDTO.setReserveStatus(ReserveStatus.RESERVED);

        List<PaymentHistoryDTO> paymentHistoryDTOList = paymentHistoryService.findByReserveHistoryId(reserveId);

        //Второй вариант
        //Начало второго варианта {
        paymentHistoryDTO.setCash(cash);
        double deposit=0;
        if (Objects.nonNull(paymentHistoryDTOList)){
            deposit = paymentHistoryDTOList.stream().mapToDouble(PaymentHistoryDTO::getCash).sum();
        }

        if (deposit + paymentHistoryDTO.getCash() >= reserveHistoryDTO.getTotalPrice()) {
            reserveHistoryDTO.setReserveStatus(ReserveStatus.PAID);
        }
        // } конец второго варианта
            reserveHistoryDTO = save(reserveHistoryDTO);
            paymentHistoryDTO.setReserveHistory(reserveHistoryDTO);
            PaymentHistoryDTO paymentHistoryDTOSaved = paymentHistoryService.save(paymentHistoryDTO);

            ReserveOutput reserveOutput = new ReserveOutput();
            reserveOutput.setCash(paymentHistoryDTOSaved.getCash() - reserveOutput.getTotalPrice());
            reserveOutput.setClientId(reserveHistoryDTO.getUser().getId());
            reserveOutput.setTotalPrice(reserveHistoryDTO.getTotalPrice() - cash);
            reserveOutput.setReserveStatus(reserveHistoryDTO.getReserveStatus());
            reserveOutput.setReserveId(reserveHistoryDTO.getId());
            reserveOutput.setPropertyId(reserveHistoryDTO.getProperty().getId());
            reserveOutput.setCheckInDate(reserveHistoryDTO.getCheckInDate());
            reserveOutput.setCheckOutDate(reserveHistoryDTO.getCheckOutDate());
            return ResponseEntity.status(HttpStatus.OK).body(ReserveHistoryMapper.INSTANCE.toReserveOutputDTO(reserveHistoryDTO, cash));

        }

    @Override
    public ResponseEntity<PaymentOutput> refund(Long paymentId, Long reserveId, Long clientId) {

        PaymentHistoryDTO paymentHistoryDTO = paymentHistoryService.findById(paymentId);

        ReserveHistoryDTO reserveHistoryDTO = findById(reserveId);

        UserDTO userDTO = userService.findById(clientId);

        List<PaymentHistoryDTO> paymentHistoryDTOList = paymentHistoryService.findByReserveHistoryId(reserveId);

        if (!paymentHistoryDTOList.isEmpty())
        {paymentHistoryDTOList.stream().mapToDouble(PaymentHistoryDTO::getCash).sum();}

        double refundMoney = paymentHistoryDTO.getCash() * 30.0 / 100;

        PaymentOutput paymentOutput = new PaymentOutput();
        paymentOutput.setReserveStatus(ReserveStatus.CANCELLED);
        paymentOutput.setCash(refundMoney);






        /**
         * чтоб вернуть 30 процент платежа
         * нам нужно найти ReserveHistory по полученной reserveId
         * по найденному ReserveHistory reserve найти все платежи т.е
         * List<PaymentHistoryDto> paymentHistoryDtoList = paymentHistoryService.findByReserveHistory(reserve)
         * использовать stream просуммировать в paymentHistoryDtoList поле cash
         * и от найденной суммы вернуть 30 процент
         *
         */

        return null;
    }

        private boolean isAvailableBetween (List < ReserveHistoryDTO > reserveHistoryDTOList, LocalDate
        checkInDate, LocalDate checkOutDate){
            return reserveHistoryDTOList.stream()
                    .anyMatch(x ->
                            (checkInDate.isEqual(checkOutDate))
                                    ||
                                    (x.getCheckInDate().isEqual(checkInDate) || x.getCheckOutDate().isEqual(checkOutDate))
                                    ||
                                    (x.getCheckInDate().isBefore(checkInDate) && x.getCheckOutDate().isAfter(checkOutDate))
                                    ||
                                    (x.getCheckInDate().isAfter(checkInDate) && x.getEditDate().isBefore(checkOutDate)));
        }
    }

