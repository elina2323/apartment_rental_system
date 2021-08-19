package kg.project.apartment_rental_system.mapper;

import kg.project.apartment_rental_system.model.dto.CodeDTO;
import kg.project.apartment_rental_system.model.dto.RequestDTO;
import kg.project.apartment_rental_system.model.dto.UserDTO;
import kg.project.apartment_rental_system.model.entity.Code;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface CodeMapper {

    CodeMapper INSTANCE = Mappers.getMapper(CodeMapper.class);

    default Code toCode(UserDTO userDTO, int result, RequestDTO requestDTO){

        Code code = new Code();

        code.setUser(UserMapper.INSTANCE.toUser(userDTO));

        code.setStartDate(LocalDateTime.now());
        code.setEndDate(LocalDateTime.now().plusHours(1));
        requestDTO.setSuccess(result == 1);
        return code;
    }

    Code toCode(CodeDTO codeDTO);

    CodeDTO toCodeDTO(Code code);

    List<Code> toCodeList(List<CodeDTO> codeDTOList);

    List<CodeDTO> toCodeDTOList(List<Code> codeList);

}
