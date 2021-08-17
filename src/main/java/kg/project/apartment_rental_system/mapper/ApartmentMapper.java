package kg.project.apartment_rental_system.mapper;

import kg.project.apartment_rental_system.model.dto.PropertyDTO;
import kg.project.apartment_rental_system.model.entity.Property;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ApartmentMapper {

    ApartmentMapper INSTANCE = Mappers.getMapper(ApartmentMapper.class);


    Property toApartment(PropertyDTO propertyDTO);

    PropertyDTO toApartmentDTO(Property property);

    List<Property> toApartmentList(List<PropertyDTO> propertyDTOList);

    List<PropertyDTO> toApartmentDTOList(List<Property> propertyList);
}
