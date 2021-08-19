package kg.project.apartment_rental_system.model.entity;

import kg.project.apartment_rental_system.model.enums.CodeStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "codes")
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    String code;

    @CreationTimestamp
    LocalDateTime startDate;

    @LastModifiedDate
    LocalDateTime endDate;

    @Enumerated(value = EnumType.STRING)
    CodeStatus codeStatus;

    @ManyToOne
    @JoinColumn(columnDefinition = "user_id")
    User user;

}
