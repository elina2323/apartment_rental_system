package kg.project.apartment_rental_system.model.dto;

import kg.project.apartment_rental_system.model.entity.User;
import kg.project.apartment_rental_system.model.enums.ApartmentStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApartmentDTO {

    Long id;

    int roomAmount;

    String address;

    double pricePerUnit;

    ApartmentStatus apartmentStatus;

    UserDTO user;

    UnitDTO unit;

    String otherDetails;


}
