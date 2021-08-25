package kg.project.apartment_rental_system.model.dto.frontside.output;

import kg.project.apartment_rental_system.model.enums.ReserveStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentOutput {

    double cash;
    ReserveStatus reserveStatus;
}
