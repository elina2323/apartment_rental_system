package kg.project.apartment_rental_system.controller.v1;

import kg.project.apartment_rental_system.controller.base.BaseController;
import kg.project.apartment_rental_system.model.dto.PaymentHistoryDTO;
import kg.project.apartment_rental_system.service.PaymentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/payment")
public class PaymentHistoryController implements BaseController<PaymentHistoryDTO, Long> {

    private PaymentHistoryService paymentHistoryService;

    @Autowired
    public PaymentHistoryController(PaymentHistoryService paymentHistoryService) {
        this.paymentHistoryService = paymentHistoryService;
    }

    @Override
    public ResponseEntity<?> save(PaymentHistoryDTO paymentHistoryDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(PaymentHistoryDTO paymentHistoryDTO) {
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

    @PostMapping("/pay")
    public ResponseEntity<?> pay(@RequestParam Long reserveId, @RequestParam double cash, @RequestParam Long clientId){
        return new ResponseEntity<>(paymentHistoryService.savePayment(clientId, reserveId, cash), HttpStatus.ACCEPTED);
    }


}
