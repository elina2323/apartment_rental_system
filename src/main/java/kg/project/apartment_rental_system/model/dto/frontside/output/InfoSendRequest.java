package kg.project.apartment_rental_system.model.dto.frontside.output;

import lombok.Data;

@Data
public class InfoSendRequest {
    private String phone;
    private String msg;
    private String sender;
}
