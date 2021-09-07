package kg.project.apartment_rental_system.model.dto.frontside.output;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    LocalDate checkInDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    LocalDate checkOutDate;

    Long propertyId;

    Long clientId;

    Long reserveId;

    double totalPrice;

    double cash;

    ReserveStatus reserveStatus;


}
