package kg.project.apartment_rental_system.mapper;

import kg.project.apartment_rental_system.model.dto.TownSuburbDTO;
import kg.project.apartment_rental_system.model.entity.TownSuburb;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TownSuburbMapper {

    TownSuburbMapper INSTANCE = Mappers.getMapper(TownSuburbMapper.class);

    TownSuburb toTownSuburb(TownSuburbDTO townSuburbDTO);

    TownSuburbDTO toTownSuburbDTO(TownSuburb townSuburb);

    List<TownSuburb> toTownSuburbList(List<TownSuburbDTO> townSuburbDTOList);

    List<TownSuburbDTO> toTownSuburbDTOList(List<TownSuburb> townSuburbList);
}
