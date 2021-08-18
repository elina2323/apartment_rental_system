package kg.project.apartment_rental_system.mapper;

import kg.project.apartment_rental_system.model.dto.DistrictDTO;
import kg.project.apartment_rental_system.model.entity.District;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DistrictMapper {

    DistrictMapper INSTANCE = Mappers.getMapper(DistrictMapper.class);

    District toDistrict(DistrictDTO districtDTO);

    DistrictDTO toDistrictDTO(District district);

    List<District> toDistrictList(List<DistrictDTO> districtDTOList);

    List<DistrictDTO> toDistrictDTOList(List<District> districtList);
}
