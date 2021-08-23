package kg.project.apartment_rental_system.controller.v1;

import kg.project.apartment_rental_system.controller.base.BaseController;
import kg.project.apartment_rental_system.model.dto.UserDTO;
import kg.project.apartment_rental_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController implements BaseController<UserDTO, Long> {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @Override
    public ResponseEntity<?> save(UserDTO userDTO) {
        return new ResponseEntity<>(userService.save(userDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> update(UserDTO userDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<?>> findAll() {
        return null;
    }

    @GetMapping("/find-by-phone")
    public ResponseEntity<?> findByPhoneNumber(String phone){

        return new ResponseEntity<>(userService.findUserByPhone(phone), HttpStatus.FOUND);
    }
}
