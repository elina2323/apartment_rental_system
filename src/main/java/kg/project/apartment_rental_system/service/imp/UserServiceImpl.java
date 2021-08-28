package kg.project.apartment_rental_system.service.imp;

import kg.project.apartment_rental_system.dao.UserRepo;
import kg.project.apartment_rental_system.exception.ResourceNotFoundException;
import kg.project.apartment_rental_system.mapper.TypeMapper;
import kg.project.apartment_rental_system.mapper.UserMapper;
import kg.project.apartment_rental_system.model.dto.UserDTO;
import kg.project.apartment_rental_system.model.entity.Request;
import kg.project.apartment_rental_system.model.entity.Type;
import kg.project.apartment_rental_system.model.entity.User;
import kg.project.apartment_rental_system.service.CodeService;
import kg.project.apartment_rental_system.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDTO save(UserDTO userDTO) {

        log.info("IN UserServiceImpl save {}", userDTO);

        User user = UserMapper.INSTANCE.toUser(userDTO);
        /*if(user == userRepo.findUserByPhone(userDTO.getPhone())){
           throw new RuntimeException("Такой пользователь уже существует");
        }*/
        user = userRepo.save(user);
        return UserMapper.INSTANCE.toUserDTO(user);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {

        log.info("IN UserServiceImpl update {}", userDTO);

        return null;
    }

    @Override
    public void removeByID(Long id) {

    }

    @Override
    public UserDTO findById(Long id) throws ResourceNotFoundException {

        log.info("IN UserServiceImpl findById {}", id);
        User user = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Пользователь с таким id \"%s\" не найден" + id));
        return UserMapper.INSTANCE.toUserDTO(user);
    }

    @Override
    public List<UserDTO> findAll() {
        return null;
    }

    @Override
    public UserDTO checkBlockDate(Long id, LocalDate localDate) {

        return null;
    }

    @Override
    public UserDTO findUserByPhone(String phone) {

        log.info("IN UserServiceImpl findUserByPhone {}", phone);

        User user = userRepo.findUserByPhone(phone);
        return UserMapper.INSTANCE.toUserDTO(user);
    }
}
