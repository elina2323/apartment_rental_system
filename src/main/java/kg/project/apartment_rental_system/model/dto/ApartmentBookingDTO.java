package kg.project.apartment_rental_system.model.dto;

import kg.project.apartment_rental_system.model.entity.Apartment;
import kg.project.apartment_rental_system.model.entity.Unit;
import kg.project.apartment_rental_system.model.entity.User;
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

    UnitDTO unit;

    double pricePerUnit;

    double totalPrice;

    UserDTO user;
}
