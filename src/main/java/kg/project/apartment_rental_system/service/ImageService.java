package kg.project.apartment_rental_system.service;

import kg.project.apartment_rental_system.model.dto.ImageDTO;
import kg.project.apartment_rental_system.model.dto.PropertyDTO;
import kg.project.apartment_rental_system.model.dto.frontside.input.ImageInput;
import kg.project.apartment_rental_system.service.base.BaseService;

import java.util.List;

public interface ImageService extends BaseService<ImageDTO, Long> {

    List<ImageDTO> saveInput(List<ImageInput> imageInputList);

    void saveByUrl(String url, PropertyDTO propertyDTO);
}
