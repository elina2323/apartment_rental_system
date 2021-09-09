package kg.project.apartment_rental_system.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.project.apartment_rental_system.model.enums.ReserveStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReserveHistoryDTO {

    Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    LocalDate checkInDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    LocalDate checkOutDate;

    PropertyDTO property;

    UserDTO user;

    double totalPrice;

    ReserveStatus reserveStatus;

    LocalDate addDate;

    LocalDate editDate;


}
