package kg.project.apartment_rental_system.service;

import kg.project.apartment_rental_system.model.dto.CodeDTO;
import kg.project.apartment_rental_system.model.dto.RequestDTO;

public interface RequestService {

    RequestDTO saveRequest(CodeDTO codeDTO, boolean isSuccess);

    int getCountOfUnsuccessfulRequests(CodeDTO code, boolean isSuccess);
}
