package kg.project.apartment_rental_system.model.entity;

import kg.project.apartment_rental_system.model.dto.ReserveHistoryDTO;
import kg.project.apartment_rental_system.model.enums.ReserveStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "reserve_histories")
public class ReserveHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @UpdateTimestamp
    LocalDate checkInDate;

    @LastModifiedDate
    LocalDate checkOutDate;

    @ManyToOne
    @JoinColumn(columnDefinition = "property_id")
    Property property;

    @ManyToOne
    @JoinColumn(columnDefinition = "user_id")
    User user;

    @NonNull
    double totalPrice;

    @Enumerated(value = EnumType.STRING)
    ReserveStatus reserveStatus;

    LocalDate addDate;

    LocalDate editDate;

}
