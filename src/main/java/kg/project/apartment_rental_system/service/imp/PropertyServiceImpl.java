package kg.project.apartment_rental_system.service.imp;

import kg.project.apartment_rental_system.dao.PropertyRepo;
import kg.project.apartment_rental_system.exception.ResourceNotFoundException;
import kg.project.apartment_rental_system.mapper.DistrictMapper;
import kg.project.apartment_rental_system.mapper.PropertyMapper;
import kg.project.apartment_rental_system.model.dto.DistrictDTO;
import kg.project.apartment_rental_system.model.dto.PropertyDTO;
import kg.project.apartment_rental_system.model.dto.RegionDTO;
import kg.project.apartment_rental_system.model.dto.TownSuburbDTO;
import kg.project.apartment_rental_system.model.entity.District;
import kg.project.apartment_rental_system.model.entity.Property;
import kg.project.apartment_rental_system.service.PropertyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class PropertyServiceImpl implements PropertyService {

    private PropertyRepo propertyRepo;

    @Autowired
    public PropertyServiceImpl(PropertyRepo propertyRepo) {
        this.propertyRepo = propertyRepo;
    }

    @Override
    public PropertyDTO save(PropertyDTO propertyDTO) {

        log.info("IN PropertyServiceImpl save {}", propertyDTO);
        Property property = PropertyMapper.INSTANCE.toProperty(propertyDTO);
        property = propertyRepo.save(property);
        return PropertyMapper.INSTANCE.toPropertyDTO(property);
    }

    @Override
    public PropertyDTO findById(Long id)
            throws ResourceNotFoundException {
        log.info("IN PropertyServiceImpl findById {}", id);
        Property property = propertyRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Недвижимость с таким id \"%s\" не найдена" + id));
        return PropertyMapper.INSTANCE.toPropertyDTO(property);
    }

    @Override
    public List<PropertyDTO> findByTownSuburbName(String name) {

        log.info("IN PropertyServiceImpl findAllByTownSuburbName");
        return PropertyMapper.INSTANCE.toPropertyDTOList(propertyRepo.findAll());
    }

    @Override
    public List<PropertyDTO> findByDistrictName(String name) {
        log.info("IN PropertyServiceImpl findByAllDistrictName");
        return PropertyMapper.INSTANCE.toPropertyDTOList(propertyRepo.findAll());
    }

    @Override
    public List<PropertyDTO> findByRegionName(String name) {
        log.info("IN PropertyServiceImpl findAllByRegionName");
        return PropertyMapper.INSTANCE.toPropertyDTOList(propertyRepo.findAll());
    }


}
