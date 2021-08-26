package kg.project.apartment_rental_system.service.imp;

import jdk.nashorn.internal.runtime.PropertyMap;
import kg.project.apartment_rental_system.dao.ImageRepo;
import kg.project.apartment_rental_system.exception.ResourceNotFoundException;
import kg.project.apartment_rental_system.mapper.ImageMapper;
import kg.project.apartment_rental_system.mapper.PropertyMapper;
import kg.project.apartment_rental_system.model.dto.ImageDTO;
import kg.project.apartment_rental_system.model.dto.PropertyDTO;
import kg.project.apartment_rental_system.model.dto.frontside.input.ImageInput;
import kg.project.apartment_rental_system.model.entity.Image;
import kg.project.apartment_rental_system.model.entity.Property;
import kg.project.apartment_rental_system.service.ImageService;
import kg.project.apartment_rental_system.service.PropertyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private ImageRepo imageRepo;

    @Autowired
    private PropertyMapper propertyMapper;


    @Override
    public List<ImageDTO> saveInput(List<ImageInput> imageInputList) {

        return imageInputList.stream().map(x-> {
            ImageDTO imageDTO = new ImageDTO();
            imageDTO.setProperty(propertyMapper.toProperty(propertyService.findById(x.getPropertyId())));
            imageDTO.setOrderNum(x.getOrderNum());
            imageDTO.setUrl(x.getUrl());
            return save(imageDTO);
        }).collect(Collectors.toList());
    }


    @Override
    public void saveByUrl(String url, PropertyDTO propertyDTO) {

        log.info("IN ImageServiceImpl saveByUrl {}", url);

        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setProperty(propertyDTO);
        imageDTO.setUrl(url);

    }

    @Override
    public ImageDTO save(ImageDTO imageDTO) {

        log.info("IN ImageServiceImpl save {}", imageDTO);
        Image image = ImageMapper.INSTANCE.toImage(imageDTO);
        image = imageRepo.save(image);
        return ImageMapper.INSTANCE.toImageDTO(image);
    }

    @Override
    public ImageDTO update(ImageDTO imageDTO) {
        return null;
    }

    @Override
    public void removeByID(Long id) {

    }

    @Override
    public ImageDTO findById(Long id) throws ResourceNotFoundException {
        log.info("IN ImageServiceImpl findById {}", id);
        Image image = imageRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Изображение с таким id \"%s\" не найдено" + id));
        return ImageMapper.INSTANCE.toImageDTO(image);
    }

    @Override
    public List<ImageDTO> findAll() {
        return null;
    }
}
