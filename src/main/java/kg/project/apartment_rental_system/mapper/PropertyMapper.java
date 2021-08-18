package kg.project.apartment_rental_system.mapper;

import kg.project.apartment_rental_system.model.dto.PropertyDTO;
import kg.project.apartment_rental_system.model.entity.Property;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface PropertyMapper {

    PropertyMapper INSTANCE = Mappers.getMapper(PropertyMapper.class);

    default Property toProperty(PropertyDTO propertyDTO){

        Property property = new Property();

        property.setId(propertyDTO.getId());
        property.setAddDate(propertyDTO.getAddDate());
        property.setAddress(propertyDTO.getAddress());
        property.setArea(propertyDTO.getArea());
        property.setDescription(propertyDTO.getDescription());
        property.setDistrict(DistrictMapper.INSTANCE.toDistrict(propertyDTO.getDistrict()));
        property.setEditDate(propertyDTO.getEditDate());
        property.setFloor(propertyDTO.getFloor());
        property.setFurniture(propertyDTO.isFurniture());
        property.setInternet(propertyDTO.isInternet());
        property.setLan(propertyDTO.getLan());
        property.setLon(propertyDTO.getLon());
        property.setPrice(propertyDTO.getPrice());
        property.setRoomAmount(propertyDTO.getRoomAmount());
        property.setTownSuburb(TownSuburbMapper.INSTANCE.toTownSuburb(propertyDTO.getTownSuburb()));
        property.setType(TypeMapper.INSTANCE.toType(propertyDTO.getType()));
        property.setUser(UserMapper.INSTANCE.toUser(propertyDTO.getUser()));
        return property;
    }

    default PropertyDTO toPropertyDTO(Property property){
        PropertyDTO propertyDTO = new PropertyDTO();

        propertyDTO.setId(property.getId());
        propertyDTO.setAddDate(property.getAddDate());
        propertyDTO.setAddress(property.getAddress());
        propertyDTO.setArea(property.getArea());
        propertyDTO.setDescription(property.getDescription());
        propertyDTO.setDistrict(DistrictMapper.INSTANCE.toDistrict(property.getDistrict()));
        propertyDTO.setEditDate(property.getEditDate());
        propertyDTO.setFloor(property.getFloor());
        propertyDTO.setFurniture(property.isFurniture());
        propertyDTO.setInternet(property.isInternet());
        propertyDTO.setLan(property.getLan());
        propertyDTO.setLon(property.getLon());
        propertyDTO.setPrice(property.getPrice());
        propertyDTO.setRoomAmount(property.getRoomAmount());
        propertyDTO.setTownSuburb(TownSuburbMapper.INSTANCE.toTownSuburb(property.getTownSuburb()));
        propertyDTO.setType(TypeMapper.INSTANCE.toType(property.getType()));
        propertyDTO.setUser(UserMapper.INSTANCE.toUser(property.getUser()));

        return propertyDTO;
    }

    List<Property> toPropertyList(List<PropertyDTO> propertyDTOList);

    default List<PropertyDTO> toPropertyDTOList(List<Property> propertyList){
        return propertyList.stream().map(x->{

            PropertyDTO propertyDTO = new PropertyDTO();

            propertyDTO.setId(x.getId());
            propertyDTO.setAddDate(x.getAddDate());
            propertyDTO.setAddress(x.getAddress());
            propertyDTO.setArea(x.getArea());
            propertyDTO.setDescription(x.getDescription());
            propertyDTO.setDistrict(DistrictMapper.INSTANCE.toDistrict(x.getDistrict()));
            propertyDTO.setEditDate(x.getEditDate());
            propertyDTO.setFloor(x.getFloor());
            propertyDTO.setFurniture(x.isFurniture());
            propertyDTO.setInternet(x.isInternet());
            propertyDTO.setLan(x.getLan());
            propertyDTO.setLon(x.getLon());
            propertyDTO.setPrice(x.getPrice());
            propertyDTO.setRoomAmount(x.getRoomAmount());
            propertyDTO.setTownSuburb(TownSuburbMapper.INSTANCE.toTownSuburb(x.getTownSuburb()));
            propertyDTO.setType(TypeMapper.INSTANCE.toType(x.getType()));
            propertyDTO.setUser(UserMapper.INSTANCE.toUser(x.getUser()));
            return propertyDTO;

        }).collect(Collectors.toList());
    }
}
