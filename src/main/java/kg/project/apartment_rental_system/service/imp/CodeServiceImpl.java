package kg.project.apartment_rental_system.service.imp;

import kg.project.apartment_rental_system.dao.CodeRepo;
import kg.project.apartment_rental_system.mapper.CodeMapper;
import kg.project.apartment_rental_system.mapper.UserMapper;
import kg.project.apartment_rental_system.model.dto.CodeDTO;
import kg.project.apartment_rental_system.model.dto.RequestDTO;
import kg.project.apartment_rental_system.model.dto.UserDTO;
import kg.project.apartment_rental_system.model.entity.Code;
import kg.project.apartment_rental_system.model.enums.CodeStatus;
import kg.project.apartment_rental_system.service.CodeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CodeServiceImpl implements CodeService {

    private final CodeRepo codeRepo;


    @Override
    public CodeDTO saveCode(UserDTO userDTO, String generatedCode) {
        log.info("IN CodeServiceImpl saveCode {}", userDTO);

        Code newCode = new Code();
        newCode.setUser(UserMapper.INSTANCE.toUser(userDTO));
        newCode.setCode(generatedCode);
        newCode.setStartDate(LocalDateTime.now());
        newCode.setEndDate(LocalDateTime.now().plusHours(1));
        newCode.setCodeStatus(CodeStatus.NEW);
        newCode = codeRepo.save(newCode);
        return CodeMapper.INSTANCE.toCodeDTO(newCode);
    }



    @Override
    public CodeDTO getCodeByUserAndCodeStatus(UserDTO userDTO, CodeStatus codeStatus) {

        log.info("IN CodeServiceImpl getCodeByUserAndCodeStatus {}", userDTO);

        Code code = codeRepo.findByUserAndCodeStatus(UserMapper.INSTANCE.toUser(userDTO),codeStatus);
        return CodeMapper.INSTANCE.toCodeDTO(code);
    }

    @Override
    public CodeDTO updateCode(CodeDTO oldCode) {

        log.info("IN CodeServiceImpl updateCode {}", oldCode);

        Code code = CodeMapper.INSTANCE.toCode(oldCode);
        code = codeRepo.save(code);
        return CodeMapper.INSTANCE.toCodeDTO(code);
    }

    @Override
    public CodeDTO getCodeByUserAndCodeStatusAndStartDate(UserDTO userDTO, CodeStatus codeStatus, LocalDateTime startDate) {

        log.info("IN CodeServiceImpl getCodeByUserAndCodeStatusAndStartDate {}", userDTO);

        Code code = codeRepo.findByUserAndCodeStatusAndStartDateAfter(UserMapper.INSTANCE.toUser(userDTO),codeStatus,startDate);
        return CodeMapper.INSTANCE.toCodeDTO(code);
    }


}
