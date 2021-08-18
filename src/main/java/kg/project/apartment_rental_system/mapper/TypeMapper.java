package kg.project.apartment_rental_system.mapper;

import kg.project.apartment_rental_system.model.dto.TypeDTO;
import kg.project.apartment_rental_system.model.entity.Type;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TypeMapper {

    TypeMapper INSTANCE = Mappers.getMapper(TypeMapper.class);

    Type toType(TypeDTO typeDTO);

    TypeDTO toTypeDTO(Type type);

    List<Type> toTypeList(List<TypeDTO> typeDTOList);

    List<TypeDTO> toTypeDTOList(List<Type> typeList);
}
