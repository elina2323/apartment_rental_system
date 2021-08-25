package kg.project.apartment_rental_system.controller.v1;

import kg.project.apartment_rental_system.controller.base.BaseController;
import kg.project.apartment_rental_system.model.dto.ReserveHistoryDTO;
import kg.project.apartment_rental_system.model.dto.frontside.output.ReserveOutput;
import kg.project.apartment_rental_system.model.entity.ReserveHistory;
import kg.project.apartment_rental_system.service.ReserveHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/reservation")
public class ReserveHistoryController implements BaseController<ReserveHistoryDTO, Long> {

    private ReserveHistoryService reserveHistoryService;

    @Autowired
    public ReserveHistoryController(ReserveHistoryService reserveHistoryService) {
        this.reserveHistoryService = reserveHistoryService;
    }

    @Override
    public ResponseEntity<?> save(ReserveHistoryDTO reserveHistoryDTO) {
        return new ResponseEntity<>(reserveHistoryService.save(reserveHistoryDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> update(ReserveHistoryDTO reserveHistoryDTO) {
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


}
