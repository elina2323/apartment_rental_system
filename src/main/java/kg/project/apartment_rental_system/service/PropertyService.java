package kg.project.apartment_rental_system.service;

import kg.project.apartment_rental_system.model.dto.DistrictDTO;
import kg.project.apartment_rental_system.model.dto.PropertyDTO;
import kg.project.apartment_rental_system.model.dto.RegionDTO;
import kg.project.apartment_rental_system.model.dto.TownSuburbDTO;

import java.util.List;

public interface PropertyService {

    PropertyDTO save(PropertyDTO propertyDTO);

    PropertyDTO findById(Long id);

    List<PropertyDTO> findByTownSuburbName(String name);

    List<PropertyDTO> findByDistrictName(String name);

    List<PropertyDTO> findByRegionName(String name);

    List<PropertyDTO> findByTypeId(Long typeId);
}
