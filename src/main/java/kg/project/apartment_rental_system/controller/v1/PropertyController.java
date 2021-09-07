package kg.project.apartment_rental_system.controller.v1;

import kg.project.apartment_rental_system.model.dto.PropertyDTO;
import kg.project.apartment_rental_system.model.dto.frontside.input.PropertyInput;
import kg.project.apartment_rental_system.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/property")
public class PropertyController {

    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(PropertyInput propertyInput) {
        return new ResponseEntity<>(propertyService.save(propertyInput), HttpStatus.CREATED);
    }

    @GetMapping("/get-district")
    public ResponseEntity<List<?>> findByDistrictName(@RequestParam String name){

        return new ResponseEntity<>(propertyService.findByDistrictName(name), HttpStatus.FOUND);
    }

    @GetMapping("/get-town")
    public ResponseEntity<List<?>> findByTownName(@RequestParam String name){

        return new ResponseEntity<>(propertyService.findByTownSuburbName(name), HttpStatus.FOUND);
    }

    @GetMapping("/get-region")
    public ResponseEntity<List<?>> findByRegionName(@RequestParam String name){

        return new ResponseEntity<>(propertyService.findByRegionName(name), HttpStatus.FOUND);
    }

    @GetMapping("/get-type")
    private  ResponseEntity<List<?>> findByType(@RequestParam Long typeId){
        return new ResponseEntity<>(propertyService.findByTypeId(typeId), HttpStatus.FOUND);
    }

    @GetMapping("/get-furniture")
    private ResponseEntity<List<?>> findByFurniture(@RequestParam boolean furniture){
        return new ResponseEntity<>(propertyService.findByFurnitureIs(furniture), HttpStatus.FOUND);
    }

    @GetMapping("/get-internet")
    private ResponseEntity<List<?>> findByInternet(@RequestParam boolean internet){
        return new ResponseEntity<>(propertyService.findByInternetIs(internet), HttpStatus.FOUND);
    }

    @GetMapping("/get-room")
    private ResponseEntity<List<?>> findByRoomAmount(@RequestParam int roomAmount){
        return new ResponseEntity<>(propertyService.findByRoomAmount(roomAmount), HttpStatus.FOUND);
    }

    @GetMapping("/get-floor")
    private ResponseEntity<List<?>> findByFloor(@RequestParam int floor){
        return new ResponseEntity<>(propertyService.findByFloor(floor), HttpStatus.FOUND);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(PropertyDTO propertyDTO) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/get")
    public ResponseEntity<List<?>> findAll() {
        return null;
    }
}
