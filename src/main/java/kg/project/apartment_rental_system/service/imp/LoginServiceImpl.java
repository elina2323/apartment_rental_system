package kg.project.apartment_rental_system.service.imp;

import kg.project.apartment_rental_system.mapper.UserMapper;
import kg.project.apartment_rental_system.model.dto.CodeDTO;
import kg.project.apartment_rental_system.model.dto.RequestDTO;
import kg.project.apartment_rental_system.model.dto.UserDTO;
import kg.project.apartment_rental_system.model.dto.frontside.output.InfoSendRequest;
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

    private final UserService userService;

    private final CodeService codeService;

    private final RequestService requestService;

    @Autowired
    public LoginServiceImpl(UserService userService, CodeService codeService, RequestService requestService ) {
        this.userService = userService;
        this.codeService = codeService;
        this.requestService = requestService;
    }

    /***
     * метод getCode должен вызываться из контроллера LoginController т.е первый раз пользователь будет обращаться
     * в этот метод и получать 4-х значный код чтоб пройти авторизацию (потдвердить себя) и попасть на страницу
     * чтоб посмотреть квартиры либо создать объявление
     * result не нужен
     */

    @Override
    public ResponseEntity<?> getCode(String phone) throws Exception {

        if (phone == null || phone.length() != 10) {
            throw new RuntimeException("Отсутствует номер телефона");
        }
/**
 * если пользователя нет в базе данных нужно его сохранить иначе сразу переход к проверке заблокирован или нет
 * удалить ошибку "Не удалось отправить SMS"
 * */
        UserDTO userDTO = userService.findUserByPhone(phone);
        if (userDTO != null){
            throw new RuntimeException("Пользователь уже существует");

        }
        userDTO = UserMapper.INSTANCE.addUser(phone);
        userDTO.setPhone(phone);
        userDTO = userService.save(userDTO);


        RequestDTO requestDTO;
        CodeDTO codeDTO;

        /**
         * сгенерировать код после того как проверим не заблокирован ли пользователь
         * */

        LocalDateTime localDateTime = LocalDateTime.now();

        if (userDTO.getBlockDate() != null) {

            if (localDateTime.getNano() - userDTO.getBlockDate().getNano() < 3600000) {

                long difference = localDateTime.getNano() - userDTO.getBlockDate().getNano();

                long minuteDifference = TimeUnit.MINUTES.convert(difference, TimeUnit.MILLISECONDS);

                long differenceInSeconds = TimeUnit.SECONDS.convert(difference, TimeUnit.MILLISECONDS);

                long seconds = differenceInSeconds - minuteDifference * 60;

                String userBlockedText = "Ваш аккаунт заблокирован. Повторите после " + String.format("%02d", minuteDifference) + ":" + String.format("%02d", seconds) + " минут";

                return ResponseEntity.status(HttpStatus.LOCKED).body(userBlockedText);

            }

        }

        String generatedCode = RandomStringUtils.randomAlphanumeric(4).toLowerCase();
        codeDTO = codeService.saveCode(userDTO, generatedCode);
        requestDTO = requestService.saveRequest(codeDTO, true);

        CodeDTO oldCode = codeService.getCodeByUserAndCodeStatus(userDTO, CodeStatus.NEW);
        if (oldCode != null) {
            oldCode.setCodeStatus(CodeStatus.CANCELLED);
            codeService.updateCode(oldCode);
        }

        String generatedCode1 = RandomStringUtils.randomAlphanumeric(4).toLowerCase();
        CodeDTO newCodeSMS = codeService.saveCode(userDTO, generatedCode1);
        RequestDTO requestDTO1 = requestService.saveRequest(newCodeSMS, true);
        return sendSmsCode(userDTO, generatedCode1);

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

        LocalDateTime.now().minusHours(-1);

        CodeDTO codeDTO = codeService.getCodeByUserAndCodeStatusAndStartDate(userDTO, CodeStatus.NEW,LocalDateTime.now());

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
