package kg.project.apartment_rental_system.service;

import kg.project.apartment_rental_system.model.entity.Code;
import kg.project.apartment_rental_system.model.entity.Request;

public interface CodeService {

    Code create(Long code);
    Request auth(String phone, long code);

}
