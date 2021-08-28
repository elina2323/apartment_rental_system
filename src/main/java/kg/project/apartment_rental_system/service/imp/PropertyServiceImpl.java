package kg.project.apartment_rental_system.service.imp;

import kg.project.apartment_rental_system.dao.PropertyRepo;
import kg.project.apartment_rental_system.exception.ResourceNotFoundException;
import kg.project.apartment_rental_system.mapper.PropertyMapper;
import kg.project.apartment_rental_system.model.dto.PropertyDTO;
import kg.project.apartment_rental_system.model.dto.frontside.input.PropertyInput;
import kg.project.apartment_rental_system.model.entity.Property;
import kg.project.apartment_rental_system.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepo propertyRepo;

    @Autowired
    private TownSuburbService townSuburbService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private UserService userService;

    @Autowired
    private DistrictService districtService;

    PropertyMapper propertyMapper = PropertyMapper.INSTANCE;

    @Override
    public PropertyDTO save(PropertyInput propertyInput) {

        log.info("IN PropertyServiceImpl save {}", propertyInput);
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setAddress(propertyInput.getAddress());
        propertyDTO.setArea(propertyInput.getArea());
        propertyDTO.setTownSuburb(townSuburbService.findById(propertyInput.getTownSuburbId()));
        propertyDTO.setType(typeService.findById(propertyInput.getTypeId()));
        propertyDTO.setUser(userService.findById(propertyInput.getOwnerId()));
        propertyDTO.setDistrict(districtService.findById(propertyInput.getDistrictId()));
        propertyDTO.setFloor(propertyInput.getFloor());
        propertyDTO.setFurniture(propertyInput.isFurniture());
        propertyDTO.setInternet(propertyInput.isInternet());
        propertyDTO.setLat(propertyInput.getLat());
        propertyDTO.setLon(propertyInput.getLon());
        propertyDTO.setPrice(propertyInput.getPrice());
        propertyDTO.setRoomAmount(propertyInput.getRoomAmount());
        propertyDTO.setDescription(propertyInput.getDescription());
        if (propertyInput.getPrice()<=0){
            throw new RuntimeException("Неправильно введена цена!");
        }
        return propertyMapper.toPropertyDTO(propertyRepo.save(propertyMapper.toProperty(propertyDTO)));
    }

    @Override
    public PropertyDTO findById(Long id) throws ResourceNotFoundException {
        log.info("IN PropertyServiceImpl findById {}", id);
        Property property = propertyRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Недвижимость с таким id \"%s\" не найдена" + id));
        return PropertyMapper.INSTANCE.toPropertyDTO(property);
    }

    @Override
    public List<PropertyDTO> findByTownSuburbName(String name) {

        log.info("IN PropertyServiceImpl findAllByTownSuburbName");
        return PropertyMapper.INSTANCE.toPropertyDTOList(propertyRepo.findByTownSuburbName(name));
    }

    @Override
    public List<PropertyDTO> findByDistrictName(String name) {
        log.info("IN PropertyServiceImpl findByAllDistrictName");
        return PropertyMapper.INSTANCE.toPropertyDTOList(propertyRepo.findByDistrictName(name));
    }

    @Override
    public List<PropertyDTO> findByRegionName(String name) {
        log.info("IN PropertyServiceImpl findAllByRegionName");
        return PropertyMapper.INSTANCE.toPropertyDTOList(propertyRepo.findByRegionName(name));
    }

    @Override
    public List<PropertyDTO> findByTypeId(Long typeId) {

        log.info("IN PropertyServiceImpl findByTypeId");
        return PropertyMapper.INSTANCE.toPropertyDTOList(propertyRepo.findByTypeId(typeId));
    }


}
