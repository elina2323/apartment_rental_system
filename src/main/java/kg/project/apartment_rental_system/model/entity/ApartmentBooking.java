package kg.project.apartment_rental_system.model.entity;

import kg.project.apartment_rental_system.model.entity.Apartment;
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
public class ApartmentBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    LocalDate checkInDate;

    @NonNull
    LocalDate checkOutDate;

    @NonNull
    int amountOfDays;

    @CreationTimestamp
    LocalDate dateCreated;

    @ManyToOne
    @JoinColumn(columnDefinition = "apartment_id")
    Apartment apartment;




}
