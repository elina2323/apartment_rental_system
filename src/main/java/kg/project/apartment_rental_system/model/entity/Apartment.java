package kg.project.apartment_rental_system.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "apartments")
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    int roomAmount;

    @NonNull
    String address;

    @NonNull
    double price;

    @Enumerated(value = EnumType.STRING)
    ApartmentStatus apartmentStatus;

    @ManyToOne
    @JoinColumn(columnDefinition = "users")
    User user;

    String otherDetails;


}
