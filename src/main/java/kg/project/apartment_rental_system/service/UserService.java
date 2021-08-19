package kg.project.apartment_rental_system.service;

import kg.project.apartment_rental_system.model.dto.UserDTO;

import java.time.LocalDate;

public interface UserService {

    UserDTO save(UserDTO userDTO);
    UserDTO checkBlockDate(Long id, LocalDate localDate);
    UserDTO findUserByPhone(String phone);

}
