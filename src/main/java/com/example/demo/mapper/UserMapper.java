package com.example.demo.mapper;

import com.example.demo.model.PersonalData;
import com.example.demo.model.User;
import com.example.demo.model.dto.PersonalDataDTO;
import com.example.demo.model.dto.UserDTO;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
  User userDtoToUser(UserDTO userDTO);

  UserDTO userToUserDto(User user);

  List<UserDTO> listOfUserToListOfUserDto(List<User> users);

  PersonalData personalDataDtoToPersonalData(PersonalDataDTO personalDataDTO);

  PersonalDataDTO personalDataToPersonalDataDto(PersonalData personalData);
}
