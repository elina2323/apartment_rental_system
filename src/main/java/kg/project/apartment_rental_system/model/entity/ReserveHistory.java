package kg.project.apartment_rental_system.model.entity;

import kg.project.apartment_rental_system.model.dto.ReserveHistoryDTO;
import kg.project.apartment_rental_system.model.enums.ReserveStatus;
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
@Table(name = "property_bookings")
public class ReserveHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    LocalDate checkInDate;

    @NonNull
    LocalDate checkOutDate;

    @ManyToOne
    @JoinColumn(columnDefinition = "property_id")
    Property property;

    @ManyToOne
    @JoinColumn(columnDefinition = "user_id")
    User user;

    @NonNull
    double totalPrice;

    @NonNull
    double debt;

    @Enumerated(value = EnumType.STRING)
    ReserveStatus reserveStatus;

    LocalDate addDate;

    LocalDate editDate;

}
