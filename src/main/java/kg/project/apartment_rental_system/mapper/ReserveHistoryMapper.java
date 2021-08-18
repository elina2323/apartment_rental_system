package kg.project.apartment_rental_system.mapper;

import kg.project.apartment_rental_system.model.dto.ReserveHistoryDTO;
import kg.project.apartment_rental_system.model.entity.ReserveHistory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReserveHistoryMapper {

    ReserveHistoryMapper INSTANCE = Mappers.getMapper(ReserveHistoryMapper.class);

    ReserveHistory toReserveHistory(ReserveHistoryDTO reserveHistoryDTO);

    ReserveHistoryDTO toReserveHistoryDTO(ReserveHistory reserveHistory);

    List<ReserveHistory> toReserveHistoryList(List<ReserveHistoryDTO> reserveHistoryDTOList);

    List<ReserveHistoryDTO> toReserveHistoryDTOList(List<ReserveHistory> reserveHistoryList);
}
