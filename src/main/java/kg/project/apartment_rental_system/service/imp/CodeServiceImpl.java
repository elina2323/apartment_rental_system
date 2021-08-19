package kg.project.apartment_rental_system.service.imp;

import kg.project.apartment_rental_system.dao.CodeRepo;
import kg.project.apartment_rental_system.dao.UserRepo;
import kg.project.apartment_rental_system.model.entity.Code;
import kg.project.apartment_rental_system.model.entity.Request;
import kg.project.apartment_rental_system.model.entity.User;
import kg.project.apartment_rental_system.service.CodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService {

    private final CodeRepo codeRepo;
    private UserRepo userRepo;

    @Override
    public Code create(String code) {

        Code newCode = new Code();
        String generatedString = RandomStringUtils.randomAlphanumeric(4);
        newCode.setCode(generatedString);
        codeRepo.save(newCode);
        return newCode;
    }

    @Override
    public Request auth(String phone, long code) {

    // User's Authorisation by phone
        User user = userRepo.findUserByPhone(phone);


}
