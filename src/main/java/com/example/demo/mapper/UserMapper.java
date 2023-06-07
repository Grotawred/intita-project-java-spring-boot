package com.example.demo.mapper;

import com.example.demo.model.User;
import com.example.demo.model.dto.UserDTO;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
  User userDtoToUser(UserDTO userDTO);

  UserDTO userToUserDto(User user);

  List<UserDTO> listOfUserToListOfUserDto(List<User> users);

  List<User> listOfUserDtoToListOfUser(List<UserDTO> userDTOS);
}
