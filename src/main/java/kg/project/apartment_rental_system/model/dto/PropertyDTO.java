package kg.project.apartment_rental_system.model.dto;

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

    RegionDTO region;

    LocalDate addDate;

    LocalDate editDate;

    double lan;

    double lon;


}
