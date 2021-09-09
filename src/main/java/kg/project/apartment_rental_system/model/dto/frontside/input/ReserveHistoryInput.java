package kg.project.apartment_rental_system.model.dto.frontside.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReserveHistoryInput {

    Long propertyId;
    Long clientId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    LocalDate checkInDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    LocalDate checkOutDate;
}
