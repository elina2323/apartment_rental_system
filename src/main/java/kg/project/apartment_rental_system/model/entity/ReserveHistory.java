package kg.project.apartment_rental_system.model.entity;

import kg.project.apartment_rental_system.model.enums.ReserveStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "apartment_bookings")
public class ReserveHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    LocalDate checkInDate;

    @NonNull
    LocalDate checkOutDate;

    @ManyToOne
    @JoinColumn(columnDefinition = "apartment_id")
    Property property;

    @NonNull
    double totalPrice;

    @Enumerated(value = EnumType.STRING)
    ReserveStatus reserveStatus;

    LocalDate addDate;

    LocalDate editDate;

}
