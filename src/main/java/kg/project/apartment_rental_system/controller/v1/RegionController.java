package kg.project.apartment_rental_system.controller.v1;

import kg.project.apartment_rental_system.controller.base.BaseController;
import kg.project.apartment_rental_system.model.dto.RegionDTO;
import kg.project.apartment_rental_system.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class RegionController implements BaseController<RegionDTO, Long> {

    private RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @Override
    public ResponseEntity<?> save(RegionDTO regionDTO) {
        return new ResponseEntity<>(regionService.save(regionDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> update(RegionDTO regionDTO) {
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
