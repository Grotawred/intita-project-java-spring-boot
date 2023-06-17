package com.example.demo.mapper;

import com.example.demo.model.User;
import com.example.demo.model.UserData;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.model.dto.UserDataDTO;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
  User userDtoToUser(UserDTO userDTO);

  UserDTO userToUserDto(User user);

  List<UserDTO> listOfUserToListOfUserDto(List<User> users);

  UserData userDataDtoToUserData(UserDataDTO userDataDTO);

  UserDataDTO userDataToUserDataDto(UserData userData);

  List<UserDataDTO> listOfUserDataToListOfUserDataDto(List<UserData> userdata);

}
