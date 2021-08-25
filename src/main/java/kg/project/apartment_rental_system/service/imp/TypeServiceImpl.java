package kg.project.apartment_rental_system.service.imp;

import kg.project.apartment_rental_system.dao.TypeRepo;
import kg.project.apartment_rental_system.exception.ResourceNotFoundException;
import kg.project.apartment_rental_system.mapper.TownSuburbMapper;
import kg.project.apartment_rental_system.mapper.TypeMapper;
import kg.project.apartment_rental_system.model.dto.TypeDTO;
import kg.project.apartment_rental_system.model.entity.TownSuburb;
import kg.project.apartment_rental_system.model.entity.Type;
import kg.project.apartment_rental_system.service.TypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TypeServiceImpl implements TypeService {

    private TypeRepo typeRepo;

    @Autowired
    public TypeServiceImpl(TypeRepo typeRepo) {
        this.typeRepo = typeRepo;
    }

    @Override
    public TypeDTO save(TypeDTO typeDTO) {

        log.info("IN TypeServiceImpl save {}", typeDTO);
        Type type = TypeMapper.INSTANCE.toType(typeDTO);
        type = typeRepo.save(type);
        return TypeMapper.INSTANCE.toTypeDTO(type);
    }

    @Override
    public TypeDTO update(TypeDTO typeDTO) {
        return null;
    }

    @Override
    public void removeByID(Long id) {

    }

    @Override
    public TypeDTO findById(Long id) throws ResourceNotFoundException {
        log.info("IN TypeServiceImpl findById {}", id);
        Type type = typeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Город иди населенный пункт с таким id \"%s\" не найден" + id));
        return TypeMapper.INSTANCE.toTypeDTO(type);
    }

    @Override
    public List<TypeDTO> findAll() {
        return null;
    }
}
