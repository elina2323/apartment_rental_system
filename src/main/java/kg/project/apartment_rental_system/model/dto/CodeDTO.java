package kg.project.apartment_rental_system.model.dto;

import kg.project.apartment_rental_system.model.entity.User;
import kg.project.apartment_rental_system.model.enums.CodeStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CodeDTO {

    Long id;

    Long code;

    LocalDate startDate;

    LocalDate endDate;

    CodeStatus codeStatus;

    User user;
}
