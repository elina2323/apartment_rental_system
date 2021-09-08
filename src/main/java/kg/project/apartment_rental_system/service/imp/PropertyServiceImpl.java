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
        propertyDTO.setLan(propertyInput.getLan());
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

        log.info("IN PropertyServiceImpl findAllByTownSuburbName {}", name);
        return PropertyMapper.INSTANCE.toPropertyDTOList(propertyRepo.findByTownSuburbName(name));
    }

    @Override
    public List<PropertyDTO> findByDistrictName(String name) {
        log.info("IN PropertyServiceImpl findByAllDistrictName {}" , name);
        return PropertyMapper.INSTANCE.toPropertyDTOList(propertyRepo.findByDistrictName(name));
    }

    @Override
    public List<PropertyDTO> findByRegionName(String name) {
        log.info("IN PropertyServiceImpl findAllByRegionName {}" , name);
        return PropertyMapper.INSTANCE.toPropertyDTOList(propertyRepo.findByRegionName(name));
    }

    @Override
    public List<PropertyDTO> findByTypeId(Long typeId) {

        log.info("IN PropertyServiceImpl findByTypeId {}" , typeId);
        return PropertyMapper.INSTANCE.toPropertyDTOList(propertyRepo.findByTypeId(typeId));
    }

    @Override
    public List<PropertyDTO> findByFurnitureIs(boolean furniture) {

        log.info("IN PropertyServiceImpl findByFurnitureIs {}" , furniture);
        return PropertyMapper.INSTANCE.toPropertyDTOList(propertyRepo.findByFurnitureIs(furniture));
    }

    @Override
    public List<PropertyDTO> findByInternetIs(boolean internet) {

        log.info("IN PropertyServiceImpl findByInternetIs {}" , internet);
        return PropertyMapper.INSTANCE.toPropertyDTOList(propertyRepo.findByInternetIs(internet));
    }

    @Override
    public List<PropertyDTO> findByRoomAmount(int roomAmount) {

        log.info("IN PropertyServiceImpl findByRoomAmount {}" , roomAmount);
        return PropertyMapper.INSTANCE.toPropertyDTOList(propertyRepo.findByRoomAmount(roomAmount));
    }

    @Override
    public List<PropertyDTO> findByFloor(int floor) {

        log.info("IN PropertyServiceImpl findByFloor {}" , floor);
        return PropertyMapper.INSTANCE.toPropertyDTOList(propertyRepo.findByFloor(floor));
    }


}
