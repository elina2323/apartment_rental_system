package kg.project.apartment_rental_system.model.dto;

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

    LocalDate dateCreated;

    ApartmentDTO apartment;

    double pricePerUnit;

    double totalPrice;

    UserDTO user;
}
