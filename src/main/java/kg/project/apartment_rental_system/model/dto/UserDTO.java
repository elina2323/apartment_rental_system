package kg.project.apartment_rental_system.model.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {

    Long id;

    String phone;

    LocalDateTime blockDate;
}
