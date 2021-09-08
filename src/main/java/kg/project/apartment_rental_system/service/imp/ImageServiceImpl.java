package kg.project.apartment_rental_system.service.imp;

import kg.project.apartment_rental_system.dao.ImageRepo;
import kg.project.apartment_rental_system.exception.ResourceNotFoundException;
import kg.project.apartment_rental_system.mapper.ImageMapper;
import kg.project.apartment_rental_system.mapper.PropertyMapper;
import kg.project.apartment_rental_system.model.dto.ImageDTO;
import kg.project.apartment_rental_system.model.dto.PropertyDTO;
import kg.project.apartment_rental_system.model.dto.frontside.input.ImageInput;
import kg.project.apartment_rental_system.model.entity.Image;
import kg.project.apartment_rental_system.service.ImageService;
import kg.project.apartment_rental_system.service.PropertyService;
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

    ImageMapper imageMapper = ImageMapper.INSTANCE;
    PropertyMapper propertyMapper = PropertyMapper.INSTANCE;

    @Override
    public List<ImageInput> saveImage(List<ImageInput> imageInputList) {

        log.info("IN ImageServiceImpl saveImage {}", imageInputList);

        imageInputList.stream().map(x-> {
            Image image = new Image();
            image.setProperty(propertyMapper.toProperty(propertyService.findById(x.getPropertyId())));
            image.setOrderNum(x.getOrderNum());
            image.setUrl(x.getUrl());
            image = imageRepo.save(image);
            return imageMapper.toImageDTO(image);
        }).collect(Collectors.toList());
        return imageInputList;
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
