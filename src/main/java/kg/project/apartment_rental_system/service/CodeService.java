package kg.project.apartment_rental_system.service;

import kg.project.apartment_rental_system.model.dto.CodeDTO;
import kg.project.apartment_rental_system.model.dto.RequestDTO;
import kg.project.apartment_rental_system.model.dto.UserDTO;
import kg.project.apartment_rental_system.model.enums.CodeStatus;

import java.time.LocalDateTime;
import java.util.Date;

public interface CodeService {

    CodeDTO saveCode(UserDTO user, int result, RequestDTO requestDTO);

    CodeDTO getCodeByUserAndCodeStatus(UserDTO userDTO, CodeStatus codeStatus);

    CodeDTO updateCode(CodeDTO oldCode);
    CodeDTO getCodeByUserAndCodeStatusAndStartDate(UserDTO userDTO, CodeStatus codeStatus, LocalDateTime startDate);

}
