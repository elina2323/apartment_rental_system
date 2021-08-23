package kg.project.apartment_rental_system.model.responces;

import lombok.Data;
import lombok.NonNull;

@Data
public class ErrorResponse {
    @NonNull
    private String message;
}
