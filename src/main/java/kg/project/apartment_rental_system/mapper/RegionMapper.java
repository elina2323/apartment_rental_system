package kg.project.apartment_rental_system.mapper;

import kg.project.apartment_rental_system.model.dto.RegionDTO;
import kg.project.apartment_rental_system.model.entity.Region;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RegionMapper {

    RegionMapper INSTANCE = Mappers.getMapper(RegionMapper.class);

    Region toRegion(RegionDTO regionDTO);

    RegionDTO toRegionDTO(Region region);

    List<Region> toRegionList(List<RegionDTO> regionDTOList);

    List<RegionDTO> toRegionDTOList(List<Region> regionList);


}
