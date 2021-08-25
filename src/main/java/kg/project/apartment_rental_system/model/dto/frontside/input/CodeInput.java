package kg.project.apartment_rental_system.model.dto.frontside.input;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CodeInput {

    String code;

    @CreationTimestamp
    LocalDateTime startDate;

    @LastModifiedDate
    LocalDateTime endDate;
    Long userId;
}
