package kg.project.apartment_rental_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class WrongCredentialsException extends RuntimeException {

    public WrongCredentialsException(String message) {
        super(message);
    }
}
