package kg.project.apartment_rental_system.service;

import kg.project.apartment_rental_system.model.dto.UserDTO;
import kg.project.apartment_rental_system.service.base.BaseService;

import java.time.LocalDate;

public interface UserService extends BaseService<UserDTO, Long> {

    UserDTO save(UserDTO userDTO);
    UserDTO checkBlockDate(Long id, LocalDate localDate);
    UserDTO findUserByPhone(String phone);

}
