package kg.project.apartment_rental_system.model.dto;

import kg.project.apartment_rental_system.model.entity.District;
import kg.project.apartment_rental_system.model.entity.TownSuburb;
import kg.project.apartment_rental_system.model.entity.Type;
import kg.project.apartment_rental_system.model.entity.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PropertyDTO {

    Long id;

    int roomAmount;

    String address;

    double price;

    UserDTO user;

    String description;

    int floor;

    double area;

    TypeDTO type;

    boolean internet;

    boolean furniture;

    TownSuburbDTO townSuburb;

    DistrictDTO district;

    LocalDate addDate;

    LocalDate editDate;

    String lan;

    String lon;


}
