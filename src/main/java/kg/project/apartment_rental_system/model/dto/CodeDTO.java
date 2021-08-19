package kg.project.apartment_rental_system.model.dto;

import kg.project.apartment_rental_system.model.entity.User;
import kg.project.apartment_rental_system.model.enums.CodeStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CodeDTO {

    Long id;

    String code;

    @CreationTimestamp
    LocalDateTime startDate;

    @LastModifiedDate
    LocalDateTime endDate;

    CodeStatus codeStatus;

    UserDTO user;
}
