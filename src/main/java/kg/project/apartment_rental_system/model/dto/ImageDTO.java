package kg.project.apartment_rental_system.model.dto;

import kg.project.apartment_rental_system.model.entity.Property;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageDTO {

    Long id;

    PropertyDTO property;

    String url;

    long orderNum;
}
