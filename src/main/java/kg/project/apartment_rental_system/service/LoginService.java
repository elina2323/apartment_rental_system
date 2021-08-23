package kg.project.apartment_rental_system.service;

import org.springframework.http.ResponseEntity;

public interface LoginService {

    Object getCode(String phone, int result) throws Exception;

    ResponseEntity<?> verifyCode(String phone, String smsCode) throws Exception;


}
