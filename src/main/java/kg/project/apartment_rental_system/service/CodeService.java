package kg.project.apartment_rental_system.service;

import kg.project.apartment_rental_system.model.dto.CodeDTO;
import kg.project.apartment_rental_system.model.dto.UserDTO;
import kg.project.apartment_rental_system.model.enums.CodeStatus;
import kg.project.apartment_rental_system.service.base.BaseService;

import java.time.LocalDateTime;

public interface CodeService {

    CodeDTO saveCode(UserDTO userDTO, String generatedCode);

    CodeDTO getCodeByUserAndCodeStatus(UserDTO userDTO, CodeStatus codeStatus);

    CodeDTO updateCode(CodeDTO oldCode);
    CodeDTO getCodeByUserAndCodeStatusAndStartDate(UserDTO userDTO, CodeStatus codeStatus, LocalDateTime startDate);

}
