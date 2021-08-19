package kg.project.apartment_rental_system.model.dto;

import kg.project.apartment_rental_system.model.entity.Code;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestDTO {

    Long id;

    @CreationTimestamp
    LocalDateTime addDate;

    boolean success;

    CodeDTO code;
}
