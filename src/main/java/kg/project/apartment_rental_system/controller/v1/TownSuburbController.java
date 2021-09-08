package kg.project.apartment_rental_system.controller.v1;

import kg.project.apartment_rental_system.controller.base.BaseController;
import kg.project.apartment_rental_system.model.dto.TownSuburbDTO;
import kg.project.apartment_rental_system.service.TownSuburbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/town")
public class TownSuburbController implements BaseController<TownSuburbDTO, Long> {

    private final TownSuburbService townSuburbService;

    @Autowired
    public TownSuburbController(TownSuburbService townSuburbService) {
        this.townSuburbService = townSuburbService;
    }

    @Override
    public ResponseEntity<?> save(TownSuburbDTO townSuburbDTO) {
        return new ResponseEntity<>(townSuburbService.save(townSuburbDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> update(TownSuburbDTO townSuburbDTO) {
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
