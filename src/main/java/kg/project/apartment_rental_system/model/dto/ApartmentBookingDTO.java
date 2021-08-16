package kg.project.apartment_rental_system.model.dto;

import kg.project.apartment_rental_system.model.entity.Apartment;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApartmentBookingDTO {

    Long id;

    LocalDate checkInDate;

    LocalDate checkOutDate;

    int amountOfDays;

    LocalDate dateCreated;

    Apartment apartment;
}
