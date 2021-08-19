package kg.project.apartment_rental_system.service.imp;

import kg.project.apartment_rental_system.dao.UserRepo;
import kg.project.apartment_rental_system.exception.ResourceNotFoundException;
import kg.project.apartment_rental_system.mapper.UserMapper;
import kg.project.apartment_rental_system.model.dto.UserDTO;
import kg.project.apartment_rental_system.model.entity.Request;
import kg.project.apartment_rental_system.model.entity.User;
import kg.project.apartment_rental_system.service.CodeService;
import kg.project.apartment_rental_system.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private UserService userService;
    private CodeService codeService;


    @Override
    public UserDTO save(UserDTO userDTO) {

        log.info("IN UserServiceImpl save {}", userDTO);
        User user = UserMapper.INSTANCE.toUser(userDTO);
        if(user == userRepo.findUserByPhone(userDTO.getPhone())){
           throw new RuntimeException("Такой пользователь уже существует");
        }
        user = userRepo.save(user);
        return UserMapper.INSTANCE.toUserDTO(user);
    }

    @Override
    public UserDTO checkBlockDate(Long id, LocalDate localDate) {
        return null;
    }

    @Override
    public UserDTO findUserByPhone(String phone) {
        return null;
    }
}
