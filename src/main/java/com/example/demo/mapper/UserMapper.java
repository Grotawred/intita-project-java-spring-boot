package com.example.demo.mapper;

import com.example.demo.model.User;
import com.example.demo.model.dto.UserDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
  User userDtoToUser(UserDTO userDTO);

  UserDTO userTOUserDto(User user);

  List<UserDTO> listOfUserToListOfUserDto(List<User> users);

  List<User> listOfUserDtoToListOfUser(List<UserDTO> userDTOS);
}
