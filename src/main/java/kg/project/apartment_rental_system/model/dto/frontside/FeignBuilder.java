package kg.project.apartment_rental_system.model.dto.frontside;

import kg.project.apartment_rental_system.model.dto.frontside.output.InfoSendRequest;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "UserController")
public interface FeignBuilder {

    @PostMapping("/api/v1/user/send")
    ResponseEntity<?> sendSMS(@RequestBody InfoSendRequest infoSendRequest);


}
