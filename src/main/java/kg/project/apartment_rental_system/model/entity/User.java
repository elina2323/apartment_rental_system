package kg.project.apartment_rental_system.model.entity;

import kg.project.apartment_rental_system.model.enums.UserStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    String name;

    @NonNull
    String phoneNumber;

    @NonNull
    @Length(min = 5, message = "Ваш логин должен содержать не менее 5 символов")
    String login;

    @NonNull
    @Length(min = 5, message = "Ваш пароль должен содержать не менее 5 символов")
    String password;

    @Enumerated(value = EnumType.STRING)
    UserStatus userStatus;
}
