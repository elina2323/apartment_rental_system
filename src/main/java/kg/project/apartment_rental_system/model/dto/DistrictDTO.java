package kg.project.apartment_rental_system.model.dto;

import kg.project.apartment_rental_system.model.entity.TownSuburb;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DistrictDTO {

    Long id;

    String name;

    TownSuburbDTO townSuburb;
}
