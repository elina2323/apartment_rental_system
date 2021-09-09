package kg.project.apartment_rental_system.controller.v1;

import kg.project.apartment_rental_system.model.dto.frontside.input.ReserveHistoryInput;
import kg.project.apartment_rental_system.model.responces.ErrorResponse;
import kg.project.apartment_rental_system.service.ReserveHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReserveHistoryController{

    private final ReserveHistoryService reserveHistoryService;

    @Autowired
    public ReserveHistoryController(ReserveHistoryService reserveHistoryService) {
        this.reserveHistoryService = reserveHistoryService;
    }

    @PostMapping("save")
    public ResponseEntity<?> saveReservation(@RequestBody ReserveHistoryInput reserveHistoryInput){
        try {
            return reserveHistoryService.saveReservation(reserveHistoryInput);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("pay")
    public ResponseEntity<?> executePayment(@RequestParam Long clientId, @RequestParam Long reserveId, @RequestParam double cash){
        try {
            return reserveHistoryService.executePayment(clientId, reserveId, cash);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

}
