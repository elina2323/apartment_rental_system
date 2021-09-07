package kg.project.apartment_rental_system.controller.v1;

import kg.project.apartment_rental_system.controller.base.BaseController;
import kg.project.apartment_rental_system.model.dto.TypeDTO;
import kg.project.apartment_rental_system.model.entity.Type;
import kg.project.apartment_rental_system.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/type")
public class TypeController implements BaseController<TypeDTO, Long> {

    private TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @Override
    public ResponseEntity<?> save(TypeDTO typeDTO) {
        return new ResponseEntity<>(typeService.save(typeDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> update(TypeDTO typeDTO) {
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
