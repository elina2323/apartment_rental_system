package kg.project.apartment_rental_system.mapper;

import kg.project.apartment_rental_system.model.dto.ApartmentBookingDTO;
import kg.project.apartment_rental_system.model.entity.ReserveHistory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ApartmentBookingMapper {

    ApartmentBookingMapper INSTANCE = Mappers.getMapper(ApartmentBookingMapper.class);

    ReserveHistory toApartmentBooking(ApartmentBookingDTO apartmentBookingDTO);

    ApartmentBookingDTO toApartmentBookingDTO(ReserveHistory reserveHistory);

    List<ReserveHistory> toApartmentBookingList(List<ApartmentBookingDTO> apartmentBookingDTOList);

    List<ApartmentBookingDTO> toApartmentBookingDTOList(List<ReserveHistory> reserveHistoryList);
}
