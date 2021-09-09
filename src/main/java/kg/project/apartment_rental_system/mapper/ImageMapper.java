package kg.project.apartment_rental_system.mapper;

import kg.project.apartment_rental_system.model.dto.ImageDTO;
import kg.project.apartment_rental_system.model.entity.Image;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ImageMapper {

    ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);

    Image toImage(ImageDTO imageDTO);

    ImageDTO toImageDTO(Image image);

    List<Image> toImageList(List<ImageDTO> imageDTOList);

    List<ImageDTO> toImageDTOList(List<Image> imageList);
}
