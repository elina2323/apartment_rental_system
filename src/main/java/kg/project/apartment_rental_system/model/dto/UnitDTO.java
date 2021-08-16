package kg.project.apartment_rental_system.model.dto;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UnitDTO {

    Long id;

    String unitName;
}
