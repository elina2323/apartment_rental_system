package kg.project.apartment_rental_system.model.dto.frontside.output;

import kg.project.apartment_rental_system.model.dto.PropertyDTO;
import kg.project.apartment_rental_system.model.dto.UserDTO;
import kg.project.apartment_rental_system.model.enums.ReserveStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReserveOutput {

    @CreationTimestamp
    LocalDate checkInDate;

    @LastModifiedDate
    LocalDate checkOutDate;

    Long propertyId;

    Long clientId;

    double totalPrice;

    double debt;

    ReserveStatus reserveStatus;


}
