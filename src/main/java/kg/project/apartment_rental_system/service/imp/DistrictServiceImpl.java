package kg.project.apartment_rental_system.service.imp;

import kg.project.apartment_rental_system.dao.DistrictRepo;
import kg.project.apartment_rental_system.exception.ResourceNotFoundException;
import kg.project.apartment_rental_system.mapper.DistrictMapper;
import kg.project.apartment_rental_system.model.dto.DistrictDTO;
import kg.project.apartment_rental_system.model.entity.District;
import kg.project.apartment_rental_system.service.DistrictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class DistrictServiceImpl implements DistrictService {

    private DistrictRepo districtRepo;

    @Autowired
    public DistrictServiceImpl(DistrictRepo districtRepo) {
        this.districtRepo = districtRepo;
    }

    @Override
    public DistrictDTO save(DistrictDTO districtDTO) {
        log.info("IN DistrictServiceImpl save {}", districtDTO);
        District district = DistrictMapper.INSTANCE.toDistrict(districtDTO);
        district = districtRepo.save(district);
        return DistrictMapper.INSTANCE.toDistrictDTO(district);
    }

    @Override
    public DistrictDTO update(DistrictDTO districtDTO) {
        return null;
    }

    @Override
    public void removeByID(Long id) {

    }

    @Override
    public DistrictDTO findById(Long id) throws ResourceNotFoundException {
        log.info("IN DistrictServiceImpl findById {}", id);
        District district = districtRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Район с таким id \"%s\" не найден" + id));
        return DistrictMapper.INSTANCE.toDistrictDTO(district);
    }


    @Override
    public List<DistrictDTO> findAll() {
        return null;
    }
}
