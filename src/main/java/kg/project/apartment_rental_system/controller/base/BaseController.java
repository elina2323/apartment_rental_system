package kg.project.apartment_rental_system.controller.base;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BaseController<S, T> {

    @PostMapping("/save")
    ResponseEntity<?> save(@RequestBody S s);

    @PutMapping("/update")
    ResponseEntity<?> update(@RequestBody S s);

    @GetMapping("/{id}")
    ResponseEntity<?> findById(@PathVariable T id);

    @GetMapping("/all")
    ResponseEntity<List<?>> findAll();
}