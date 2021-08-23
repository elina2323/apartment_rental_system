package kg.project.apartment_rental_system.model.dto.frontside.input;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReserveHistoryInput {

    Long propertyId;
    Long clientId;

    @CreationTimestamp
    LocalDate checkInDate;

    @LastModifiedDate
    LocalDate checkOutDate;
}
