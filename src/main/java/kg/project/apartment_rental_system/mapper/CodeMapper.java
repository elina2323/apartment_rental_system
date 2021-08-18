package kg.project.apartment_rental_system.mapper;

import kg.project.apartment_rental_system.model.dto.CodeDTO;
import kg.project.apartment_rental_system.model.entity.Code;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CodeMapper {

    CodeMapper INSTANCE = Mappers.getMapper(CodeMapper.class);

    Code toCode(CodeDTO codeDTO);

    CodeDTO toCodeDTO(Code code);

    List<Code> toCodeList(List<CodeDTO> codeDTOList);

    List<CodeDTO> toCodeDTOList(List<Code> codeList);

}
