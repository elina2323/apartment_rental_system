package kg.project.apartment_rental_system.service.imp;

import kg.project.apartment_rental_system.dao.RegionRepo;
import kg.project.apartment_rental_system.exception.ResourceNotFoundException;
import kg.project.apartment_rental_system.mapper.RegionMapper;
import kg.project.apartment_rental_system.mapper.TypeMapper;
import kg.project.apartment_rental_system.model.dto.RegionDTO;
import kg.project.apartment_rental_system.model.entity.Region;
import kg.project.apartment_rental_system.model.entity.Type;
import kg.project.apartment_rental_system.service.RegionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RegionServiceImpl implements RegionService {

    private RegionRepo regionRepo;

    @Autowired
    public RegionServiceImpl(RegionRepo regionRepo) {
        this.regionRepo = regionRepo;
    }

    @Override
    public RegionDTO save(RegionDTO regionDTO) {
        log.info("IN TypeServiceImpl save {}", regionDTO);
        Region region = RegionMapper.INSTANCE.toRegion(regionDTO);
        region = regionRepo.save(region);
        return RegionMapper.INSTANCE.toRegionDTO(region);
    }

    @Override
    public RegionDTO update(RegionDTO regionDTO) {
        return null;
    }

    @Override
    public void removeByID(Long id) {

    }

    @Override
    public RegionDTO findById(Long id)
       throws ResourceNotFoundException {
            log.info("IN RegionServiceImpl findById {}", id);
            Region region = regionRepo.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException
                            ("Регион пункт с таким id \"%s\" не найден" + id));
            return RegionMapper.INSTANCE.toRegionDTO(region);
    }

    @Override
    public List<RegionDTO> findAll() {
        return null;
    }
}
