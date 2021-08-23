package kg.project.apartment_rental_system.service.imp;

import kg.project.apartment_rental_system.dao.TownSuburbRepo;
import kg.project.apartment_rental_system.exception.ResourceNotFoundException;
import kg.project.apartment_rental_system.mapper.DistrictMapper;
import kg.project.apartment_rental_system.mapper.TownSuburbMapper;
import kg.project.apartment_rental_system.model.dto.TownSuburbDTO;
import kg.project.apartment_rental_system.model.entity.District;
import kg.project.apartment_rental_system.model.entity.TownSuburb;
import kg.project.apartment_rental_system.service.TownSuburbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TownSuburbServiceImpl implements TownSuburbService {

    private TownSuburbRepo townSuburbRepo;

    @Autowired
    public TownSuburbServiceImpl(TownSuburbRepo townSuburbRepo) {
        this.townSuburbRepo = townSuburbRepo;
    }

    @Override
    public TownSuburbDTO save(TownSuburbDTO townSuburbDTO) {
        log.info("IN TownSuburbServiceImpl save {}", townSuburbDTO);
        TownSuburb townSuburb = TownSuburbMapper.INSTANCE.toTownSuburb(townSuburbDTO);
        townSuburb = townSuburbRepo.save(townSuburb);
        return TownSuburbMapper.INSTANCE.toTownSuburbDTO(townSuburb);
    }

    @Override
    public TownSuburbDTO update(TownSuburbDTO townSuburbDTO) {
        return null;
    }

    @Override
    public void removeByID(Long id) {

    }

    @Override
    public TownSuburbDTO findById(Long id)
            throws ResourceNotFoundException {
        log.info("IN TownSuburbServiceImpl findById {}", id);
        TownSuburb townSuburb = townSuburbRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Город иди населенный пункт с таким id \"%s\" не найден" + id));
        return TownSuburbMapper.INSTANCE.toTownSuburbDTO(townSuburb);
    }

    @Override
    public List<TownSuburbDTO> findAll() {
        return null;
    }
}
