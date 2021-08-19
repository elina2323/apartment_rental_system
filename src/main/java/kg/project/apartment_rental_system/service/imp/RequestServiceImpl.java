package kg.project.apartment_rental_system.service.imp;

import kg.project.apartment_rental_system.dao.RequestRepo;
import kg.project.apartment_rental_system.mapper.CodeMapper;
import kg.project.apartment_rental_system.mapper.RequestMapper;
import kg.project.apartment_rental_system.model.dto.CodeDTO;
import kg.project.apartment_rental_system.model.entity.Request;
import kg.project.apartment_rental_system.service.RequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

    private RequestRepo requestRepo;

    @Override
    public Request saveRequest(CodeDTO codeDTO, boolean isSuccess) {

        log.info("IN RequestServiceImpl saveRequest {}", codeDTO);

        Request request = new Request();
        request.setCode(CodeMapper.INSTANCE.toCode(codeDTO));
        request.setAddDate(LocalDateTime.now());
        request.setSuccess(isSuccess);
        request = requestRepo.save(request);
        return RequestMapper.INSTANCE.toRequest(request);
    }

    @Override
    public int getCountOfUnsuccessfulRequests(CodeDTO codeDTO, boolean isSuccess) {

        return requestRepo.countRequestsByCodeAndSuccessIs(CodeMapper.INSTANCE.toCode(codeDTO),isSuccess);
    }
}
