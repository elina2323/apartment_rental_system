package kg.project.apartment_rental_system.controller.v1;

import kg.project.apartment_rental_system.controller.base.BaseController;
import kg.project.apartment_rental_system.model.dto.ImageDTO;
import kg.project.apartment_rental_system.model.dto.frontside.input.ImageInput;
import kg.project.apartment_rental_system.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/image")
public class ImageController implements BaseController<ImageDTO, Long> {

    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/save-image")
    public ResponseEntity<List<ImageDTO>> save(@RequestBody List<ImageInput> imageInputList){
        return new ResponseEntity<>(imageService.saveInput(imageInputList), HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity<?> save(ImageDTO imageDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(ImageDTO imageDTO) {
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
