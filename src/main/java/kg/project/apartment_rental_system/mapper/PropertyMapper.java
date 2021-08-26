package kg.project.apartment_rental_system.mapper;

import kg.project.apartment_rental_system.model.dto.PropertyDTO;
import kg.project.apartment_rental_system.model.entity.Property;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PropertyMapper {

    PropertyMapper INSTANCE = Mappers.getMapper(PropertyMapper.class);

    Property toProperty(PropertyDTO propertyDTO);

    PropertyDTO toPropertyDTO(Property property);

    List<Property> toPropertyList(List<PropertyDTO> propertyDTOList);

    List<PropertyDTO> toPropertyDTOList(List<Property> propertyList);
    }

