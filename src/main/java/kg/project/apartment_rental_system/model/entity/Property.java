package kg.project.apartment_rental_system.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    int roomAmount;

    @NonNull
    String address;

    @NonNull
    double price;

    @ManyToOne
    @JoinColumn(columnDefinition = "users")
    User user;

    String description;

    @NonNull
    int floor;

    @NonNull
    double area;

    @ManyToOne
    @JoinColumn(columnDefinition = "type_id")
    Type type;

    @NonNull
    boolean internet;

    @NonNull
    boolean furniture;

    @ManyToOne
    @JoinColumn(columnDefinition = "townSuburb_id")
    TownSuburb townSuburb;

    @ManyToOne
    @JoinColumn(columnDefinition = "district_id")
    District district;

    @ManyToOne
    @JoinColumn(columnDefinition = "region_id")
    Region region;

    @CreationTimestamp
    LocalDate addDate;

    @UpdateTimestamp
    LocalDate editDate;

    double lan;

    double lon;

}
