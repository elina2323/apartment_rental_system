package kg.project.apartment_rental_system.model.dto;

import kg.project.apartment_rental_system.model.entity.ReserveHistory;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentHistoryDTO {

    Long id;

    LocalDate addDate;

    double cash;

    ReserveHistory reserveHistory;
}
