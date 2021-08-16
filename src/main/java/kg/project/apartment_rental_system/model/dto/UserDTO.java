package kg.project.apartment_rental_system.model.dto;

import kg.project.apartment_rental_system.model.enums.UserStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {

    Long id;

    String name;

    String phoneNumber;

    String login;

    String password;

    UserStatus userStatus;
}
