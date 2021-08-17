package kg.project.apartment_rental_system.mapper;

import kg.project.apartment_rental_system.model.dto.ApartmentDTO;
import kg.project.apartment_rental_system.model.entity.Property;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ApartmentMapper {

    ApartmentMapper INSTANCE = Mappers.getMapper(ApartmentMapper.class);


    Property toApartment(ApartmentDTO apartmentDTO);

    ApartmentDTO toApartmentDTO(Property property);

    List<Property> toApartmentList(List<ApartmentDTO> apartmentDTOList);

    List<ApartmentDTO> toApartmentDTOList(List<Property> propertyList);
}
