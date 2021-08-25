package kg.project.apartment_rental_system.service.imp;

import kg.project.apartment_rental_system.dao.ReserveHistoryRepo;
import kg.project.apartment_rental_system.exception.ResourceNotFoundException;
import kg.project.apartment_rental_system.mapper.ReserveHistoryMapper;
import kg.project.apartment_rental_system.model.dto.PaymentHistoryDTO;
import kg.project.apartment_rental_system.model.dto.PropertyDTO;
import kg.project.apartment_rental_system.model.dto.ReserveHistoryDTO;
import kg.project.apartment_rental_system.model.dto.UserDTO;
import kg.project.apartment_rental_system.model.dto.frontside.input.ReserveHistoryInput;
import kg.project.apartment_rental_system.model.dto.frontside.output.ReserveOutput;
import kg.project.apartment_rental_system.model.entity.PaymentHistory;
import kg.project.apartment_rental_system.model.entity.ReserveHistory;
import kg.project.apartment_rental_system.model.enums.ReserveStatus;
import kg.project.apartment_rental_system.service.PaymentHistoryService;
import kg.project.apartment_rental_system.service.PropertyService;
import kg.project.apartment_rental_system.service.ReserveHistoryService;
import kg.project.apartment_rental_system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Slf4j
public class ReserveHistoryServiceImpl implements ReserveHistoryService {

    private final ReserveHistoryRepo reserveHistoryRepo;

    private final PropertyService propertyService;

    private final PaymentHistoryService paymentHistoryService;

    private final UserService userService;


    @Autowired
    public ReserveHistoryServiceImpl(ReserveHistoryRepo reserveHistoryRepo, PropertyService propertyService, PaymentHistoryService paymentHistoryService, UserService userService) {
        this.reserveHistoryRepo = reserveHistoryRepo;
        this.propertyService = propertyService;
        this.paymentHistoryService = paymentHistoryService;
        this.userService = userService;
    }

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
    public ReserveHistoryDTO saveReservation(ReserveHistoryInput reserveHistoryInput) {

        log.info("IN ReserveHistoryServiceImpl saveReservation {}", reserveHistoryInput);

        LocalDate checkInDate = reserveHistoryInput.getCheckInDate();
        LocalDate checkOutDate = reserveHistoryInput.getCheckOutDate();

        List<ReserveHistoryDTO> reserveHistoryDTOList = findAll();
        if(isAvailableBetween(reserveHistoryDTOList, checkInDate, checkOutDate)){
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
        if (reserveHistoryDTO.getCheckInDate().isAfter(reserveHistoryDTO.getCheckOutDate()) || reserveHistoryDTO.getCheckInDate().equals(reserveHistoryDTO.getCheckOutDate())){
            throw new RuntimeException("Коллизия");
        }

        ReserveHistory reserveHistory = ReserveHistoryMapper.INSTANCE.toReserveHistory(reserveHistoryDTO);
        reserveHistory = reserveHistoryRepo.save(reserveHistory);
        return ReserveHistoryMapper.INSTANCE.toReserveHistoryDTO(reserveHistory);

    }

    private double refund(double cash, int days){
        return ((cash * days) * 30.0) / 100.0;
    }

    private boolean isAvailableBetween(List<ReserveHistoryDTO> reserveHistoryDTOList, LocalDate checkInDate, LocalDate checkOutDate) {
        return reserveHistoryDTOList.stream()
                .noneMatch(x ->
                        (x.getCheckInDate().isBefore(checkInDate) || x.getCheckOutDate().isAfter(checkOutDate))
                                || (x.getCheckInDate().equals(checkInDate) && x.getCheckOutDate().equals(checkInDate)));
    }
}
