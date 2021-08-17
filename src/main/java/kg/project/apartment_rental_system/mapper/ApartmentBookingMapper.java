package kg.project.apartment_rental_system.mapper;

import kg.project.apartment_rental_system.model.dto.ReserveHistoryDTO;
import kg.project.apartment_rental_system.model.entity.ReserveHistory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ApartmentBookingMapper {

    ApartmentBookingMapper INSTANCE = Mappers.getMapper(ApartmentBookingMapper.class);

    ReserveHistory toApartmentBooking(ReserveHistoryDTO reserveHistoryDTO);

    ReserveHistoryDTO toApartmentBookingDTO(ReserveHistory reserveHistory);

    List<ReserveHistory> toApartmentBookingList(List<ReserveHistoryDTO> reserveHistoryDTOList);

    List<ReserveHistoryDTO> toApartmentBookingDTOList(List<ReserveHistory> reserveHistoryList);
}
