package kg.project.apartment_rental_system.mapper;

import kg.project.apartment_rental_system.model.dto.RequestDTO;
import kg.project.apartment_rental_system.model.entity.Request;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RequestMapper {

    RequestMapper INSTANCE = Mappers.getMapper(RequestMapper.class);

    Request toRequest(Request requestDTO);

    RequestDTO toRequestDTO(Request request);

    List<Request> toRequestList(List<RequestDTO> requestDTOList);

    List<RequestDTO> toRequestDTOList(List<Request> requestList);
}
