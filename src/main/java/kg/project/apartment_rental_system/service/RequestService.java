package kg.project.apartment_rental_system.service;

import kg.project.apartment_rental_system.model.dto.CodeDTO;
import kg.project.apartment_rental_system.model.entity.Request;

public interface RequestService {

    Request saveRequest(CodeDTO codeDTO, boolean isSuccess);

    int getCountOfUnsuccessfulRequests(CodeDTO code, boolean isSuccess);
}
