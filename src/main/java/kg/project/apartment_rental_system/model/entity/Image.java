package kg.project.apartment_rental_system.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(columnDefinition = "property_id")
    Property property;

    @NonNull
    String url;

    @NonNull
    long orderNum;
}
