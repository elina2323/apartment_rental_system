package kg.project.apartment_rental_system.model.dto;

import kg.project.apartment_rental_system.model.entity.Region;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TownSuburbDTO {

    Long id;

    String name;

    Region region;
}
