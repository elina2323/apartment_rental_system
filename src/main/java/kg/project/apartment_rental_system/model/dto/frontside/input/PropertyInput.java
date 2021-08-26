package kg.project.apartment_rental_system.model.dto.frontside.input;

import kg.project.apartment_rental_system.model.dto.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PropertyInput {

    int roomAmount;

    String address;

    double price;

    Long ownerId;

    String description;

    int floor;

    double area;

    Long typeId;

    boolean internet;

    boolean furniture;

    Long townSuburbId;

    Long districtId;

    Long regionId;

    double lat;

    double lon;
}
