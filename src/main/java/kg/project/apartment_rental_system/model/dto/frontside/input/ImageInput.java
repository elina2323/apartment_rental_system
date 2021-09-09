package kg.project.apartment_rental_system.model.dto.frontside.input;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageInput {

    Long propertyId;
    String url;
    int orderNum;

}
