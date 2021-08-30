package kg.project.apartment_rental_system.service.imp;

import kg.project.apartment_rental_system.mapper.CodeMapper;
import kg.project.apartment_rental_system.mapper.UserMapper;
import kg.project.apartment_rental_system.model.dto.CodeDTO;
import kg.project.apartment_rental_system.model.dto.RequestDTO;
import kg.project.apartment_rental_system.model.dto.UserDTO;
import kg.project.apartment_rental_system.model.dto.frontside.output.InfoSendRequest;
import kg.project.apartment_rental_system.model.entity.Code;
import kg.project.apartment_rental_system.model.entity.User;
import kg.project.apartment_rental_system.model.enums.CodeStatus;
import kg.project.apartment_rental_system.service.CodeService;
import kg.project.apartment_rental_system.service.LoginService;
import kg.project.apartment_rental_system.service.RequestService;
import kg.project.apartment_rental_system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;


@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;

    @Autowired
    private CodeService codeService;

    @Autowired
    private RequestService requestService;

    @Override
    public ResponseEntity<?> getCode(String phone) throws Exception {

        if (phone == null || phone.length() != 10) {
            throw new RuntimeException("Отсутствует номер телефона");
        }

        UserDTO userDTO = userService.findUserByPhone(phone);

        if (userDTO == null) {

            CodeDTO codeDTO;
            RequestDTO requestDTO;

            userDTO = new UserDTO();
            userDTO.setPhone(phone);
            userDTO = userService.save(userDTO);

            String generatedCode = RandomStringUtils.randomAlphanumeric(4).toLowerCase();
            codeDTO = codeService.saveCode(userDTO, generatedCode);
            requestDTO = requestService.saveRequest(codeDTO, true);
            return sendSmsCode(userDTO, generatedCode);

        } else {

            LocalDateTime localDateTime = LocalDateTime.now();

            if (userDTO.getBlockDate() != null) {

                if (localDateTime.getNano() - userDTO.getBlockDate().getNano() < 3600000) {

                    long difference = localDateTime.getNano() - userDTO.getBlockDate().getNano();

                    long minuteDifference = TimeUnit.MINUTES.convert(difference, TimeUnit.NANOSECONDS);

                    long differenceInSeconds = TimeUnit.SECONDS.convert(difference, TimeUnit.NANOSECONDS);

                    long seconds = differenceInSeconds - minuteDifference * 60;

                    String userBlockedText = "Ваш аккаунт заблокирован. Повторите после " + String.format("%02d", minuteDifference) + ":" + String.format("%02d", seconds) + " минут";

                    return ResponseEntity.status(HttpStatus.LOCKED).body(userBlockedText);

                }

            }

            CodeDTO oldCode = codeService.getCodeByUserAndCodeStatus(userDTO, CodeStatus.NEW);
            if (oldCode != null) {
                oldCode.setCodeStatus(CodeStatus.CANCELLED);
                codeService.updateCode(oldCode);
            }

            String generatedCode = RandomStringUtils.randomAlphanumeric(4).toLowerCase();
            CodeDTO newCodeSMS = codeService.saveCode(userDTO, generatedCode);
            RequestDTO requestDTO = requestService.saveRequest(newCodeSMS, true);
            return sendSmsCode(userDTO, generatedCode);

        }
    }

    private ResponseEntity<?> sendSmsCode(UserDTO userDTO, String generatedCode){

        InfoSendRequest infoSendRequest = new InfoSendRequest();
        infoSendRequest.setPhone(userDTO.getPhone());
        infoSendRequest.setSender("T-MOBILE");
        infoSendRequest.setMsg("<#>" + generatedCode + " - Vash kod podtverjdeniya. Nikomu ne peredavaite.");
        return  ResponseEntity.ok(infoSendRequest);

    }


    @Override
    public ResponseEntity<?> verifyCode(String phone, String smsCode) throws Exception {
        if (phone.equals(null) || smsCode.equals(null)){
            throw new RuntimeException("нет данных");

        }
        UserDTO userDTO = userService.findUserByPhone(phone);

        if (userDTO == null){
            throw  new RuntimeException("пользователь не найден");
        }

        CodeDTO codeDTO = codeService.getCodeByUserAndCodeStatus(userDTO, CodeStatus.NEW);

        if (codeDTO==null){

            throw new RuntimeException("Прошло более 60 минут с последней отправки запроса. Запросите код повторно");

        }

        int count = requestService.getCountOfUnsuccessfulRequests(codeDTO,false);

        if (count>=3){

            userDTO.setBlockDate(LocalDateTime.now());
            userDTO = userService.save(userDTO);
            codeDTO.setCodeStatus(CodeStatus.FAILED);
            codeDTO = codeService.updateCode(codeDTO);
            throw new RuntimeException("Количество допустимых попыток превышено");
        }

        if (codeDTO.getCode().equals(smsCode)){

            codeDTO.setCodeStatus(CodeStatus.APPROVED);
            codeDTO = codeService.updateCode(codeDTO);
            return ResponseEntity.ok(codeDTO);
        }else {

            RequestDTO requestDTO = new RequestDTO();
            requestDTO = requestService.saveRequest(codeDTO, false);
            throw new RuntimeException("Неверный код");
        }
    }

}
