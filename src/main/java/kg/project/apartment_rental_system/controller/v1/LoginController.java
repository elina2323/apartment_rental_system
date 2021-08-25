package kg.project.apartment_rental_system.controller.v1;

import kg.project.apartment_rental_system.model.responces.ErrorResponse;
import kg.project.apartment_rental_system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {


    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/verify")
    public ResponseEntity<?> verify(@RequestParam String phone, @RequestParam String smsCode){
        try {
            return loginService.verifyCode(phone, smsCode);
        } catch (Exception e) {
            return new ResponseEntity <>(new ErrorResponse(e.getMessage()), HttpStatus.CONFLICT);
        }
    }
    @GetMapping("/get")
    public ResponseEntity<?> getCode(@RequestParam String phone){
        try {
            return loginService.getCode(phone);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()),HttpStatus.CONFLICT);
        }
    }
}