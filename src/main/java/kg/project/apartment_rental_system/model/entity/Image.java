package kg.project.apartment_rental_system.model.entity;

import kg.project.apartment_rental_system.model.entity.Apartment;
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
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(columnDefinition = "apartment_id")
    Apartment apartment;
}
