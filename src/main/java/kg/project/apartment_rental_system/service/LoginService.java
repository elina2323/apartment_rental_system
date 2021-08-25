package kg.project.apartment_rental_system.service;

import org.springframework.http.ResponseEntity;

public interface LoginService {

    ResponseEntity<?> getCode(String phone) throws Exception;

    ResponseEntity<?> verifyCode(String phone, String smsCode) throws Exception;


}
