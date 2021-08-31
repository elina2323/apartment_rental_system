package kg.project.apartment_rental_system.service;

import kg.project.apartment_rental_system.model.dto.DistrictDTO;
import kg.project.apartment_rental_system.model.dto.PropertyDTO;
import kg.project.apartment_rental_system.model.dto.RegionDTO;
import kg.project.apartment_rental_system.model.dto.TownSuburbDTO;
import kg.project.apartment_rental_system.model.dto.frontside.input.PropertyInput;
import kg.project.apartment_rental_system.model.entity.Property;
import lombok.NonNull;

import java.util.List;

public interface PropertyService {

    PropertyDTO save(PropertyInput propertyInput);

    PropertyDTO findById(Long id);

    List<PropertyDTO> findByTownSuburbName(String name);

    List<PropertyDTO> findByDistrictName(String name);

    List<PropertyDTO> findByRegionName(String name);

    List<PropertyDTO> findByTypeId(Long typeId);

    List<PropertyDTO> findByFurnitureIs(boolean furniture);
    List<PropertyDTO> findByInternetIs(boolean internet);
    List<PropertyDTO> findByRoomAmount(int roomAmount);
    List<PropertyDTO> findByFloor(int floor);
}
