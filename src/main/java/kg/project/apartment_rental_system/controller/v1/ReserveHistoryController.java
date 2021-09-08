package kg.project.apartment_rental_system.controller.v1;

import kg.project.apartment_rental_system.controller.base.BaseController;
import kg.project.apartment_rental_system.model.dto.ReserveHistoryDTO;
import kg.project.apartment_rental_system.model.dto.frontside.input.ReserveHistoryInput;
import kg.project.apartment_rental_system.model.dto.frontside.output.ReserveOutput;
import kg.project.apartment_rental_system.model.entity.ReserveHistory;
import kg.project.apartment_rental_system.service.ReserveHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return new ResponseEntity<>(reserveHistoryService.saveReservation(reserveHistoryInput), HttpStatus.CREATED);
    }

    @PostMapping("pay")
    public ResponseEntity<?> executePayment(@RequestParam Long clientId, @RequestParam Long reserveId, @RequestParam double cash){
        return new ResponseEntity<>(reserveHistoryService.executePayment(clientId, reserveId, cash), HttpStatus.OK);
    }

}
