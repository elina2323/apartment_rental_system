package kg.project.apartment_rental_system.model.entity;

import kg.project.apartment_rental_system.model.enums.CodeStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

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
    Long code;

    LocalDate startDate;

    LocalDate endDate;

    @Enumerated(value = EnumType.STRING)
    CodeStatus codeStatus;

    @ManyToOne
    @JoinColumn(columnDefinition = "user_id")
    User user;

}
