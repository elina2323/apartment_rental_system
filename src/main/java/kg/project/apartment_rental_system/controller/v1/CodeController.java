package kg.project.apartment_rental_system.controller.v1;

import kg.project.apartment_rental_system.model.dto.CodeDTO;
import kg.project.apartment_rental_system.model.dto.UserDTO;
import kg.project.apartment_rental_system.model.enums.CodeStatus;
import kg.project.apartment_rental_system.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/code")
public class CodeController{

    private final CodeService codeService;

    @Autowired
    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }


    /*@PostMapping("/save")
    public ResponseEntity<?> save(UserDTO userDTO, String generatedCode) {
        return new ResponseEntity<>(codeService.saveCode(userDTO, generatedCode), HttpStatus.CREATED);
    }


    @PostMapping("/update")
    public ResponseEntity<?> update(CodeDTO oldCode) {
        CodeDTO codeDTOFound = codeService.updateCode(oldCode);
        return new ResponseEntity<>(codeService.updateCode(codeDTOFound), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getCode(UserDTO userDTO, CodeStatus codeStatus){

        return new ResponseEntity<>(codeService.getCodeByUserAndCodeStatus(userDTO, codeStatus), HttpStatus.FOUND);
    }

    @GetMapping("/get-code-date")
    public ResponseEntity<?> getCodeDate(UserDTO userDTO, CodeStatus codeStatus, @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy")LocalDateTime startDate){

        return new ResponseEntity<>(codeService.getCodeByUserAndCodeStatusAndStartDate(userDTO, codeStatus, startDate), HttpStatus.FOUND);
    }*/

}
