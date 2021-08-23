package kg.project.apartment_rental_system.service.imp;

import kg.project.apartment_rental_system.model.dto.ReserveHistoryDTO;
import kg.project.apartment_rental_system.service.ReserveHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ReserveHistoryServiceImpl implements ReserveHistoryService {
    @Override
    public ReserveHistoryDTO save(ReserveHistoryDTO reserveHistoryDTO) {
        return null;
    }

    @Override
    public ReserveHistoryDTO update(ReserveHistoryDTO reserveHistoryDTO) {
        return null;
    }

    @Override
    public void removeByID(Long id) {

    }

    @Override
    public ReserveHistoryDTO findById(Long id) {
        return null;
    }

    @Override
    public List<ReserveHistoryDTO> findAll() {
        return null;
    }
}
