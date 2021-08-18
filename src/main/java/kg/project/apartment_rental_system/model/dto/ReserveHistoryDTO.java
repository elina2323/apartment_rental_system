package kg.project.apartment_rental_system.model.dto;

import kg.project.apartment_rental_system.model.entity.Property;
import kg.project.apartment_rental_system.model.enums.ReserveStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReserveHistoryDTO {

    Long id;

    LocalDate checkInDate;

    LocalDate checkOutDate;

    PropertyDTO property;

    double totalPrice;

    ReserveStatus reserveStatus;

    LocalDate addDate;

    LocalDate editDate;
}
