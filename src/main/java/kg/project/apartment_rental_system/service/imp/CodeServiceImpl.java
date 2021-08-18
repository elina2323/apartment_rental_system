package kg.project.apartment_rental_system.service.imp;

import kg.project.apartment_rental_system.dao.CodeRepo;
import kg.project.apartment_rental_system.dao.UserRepo;
import kg.project.apartment_rental_system.exception.ResourceNotFoundException;
import kg.project.apartment_rental_system.model.entity.Code;
import kg.project.apartment_rental_system.model.entity.Request;
import kg.project.apartment_rental_system.model.entity.User;
import kg.project.apartment_rental_system.service.CodeService;
import kg.project.apartment_rental_system.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService {

    private final CodeRepo codeRepo;
    private UserRepo userRepo;

    @Override
    public Code create(Long code) {

        Code newCode = new Code();
        newCode.setCode((long) (Math.random() * (9999 - 1000)) + 1000);
        codeRepo.save(newCode);
        return newCode;
    }

    @Override
    public Request auth(String phone, long code) {
    }

    // User's Authorisation
        User user = userRepo.findUserByPhone(phone);


}
