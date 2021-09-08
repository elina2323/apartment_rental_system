package kg.project.apartment_rental_system.controller.v1;

import kg.project.apartment_rental_system.model.dto.frontside.input.ImageInput;
import kg.project.apartment_rental_system.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/image")
public class ImageController {

    @Autowired
    private ImageService imageService;


    @PostMapping("/save-image")
    public ResponseEntity<List<?>> save(@RequestBody List<ImageInput> imageInputList){
        return new ResponseEntity<>(imageService.saveImage(imageInputList), HttpStatus.CREATED);
    }

}
