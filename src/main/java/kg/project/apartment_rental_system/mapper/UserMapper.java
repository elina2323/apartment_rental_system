package kg.project.apartment_rental_system.mapper;

import kg.project.apartment_rental_system.model.dto.UserDTO;
import kg.project.apartment_rental_system.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserDTO userDTO);

    UserDTO toUserDTO(User user);

    List<User> toUserList(List<UserDTO> userDTOList);

    List<UserDTO> toUserDTOList(List<User> userList);

    default UserDTO addUser(String phone){

        UserDTO userDTO = new UserDTO();
        userDTO.setPhone(phone);
        return userDTO;
    }


}
