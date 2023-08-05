package com.example.demo.mapper;

import com.example.demo.model.PersonalData;
import com.example.demo.model.Telephone;
import com.example.demo.model.User;
import com.example.demo.model.dto.PersonalDataDTO;
import com.example.demo.model.dto.TelephoneDTO;
import com.example.demo.model.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userDtoToUser(UserDTO userDTO);

    UserDTO userToUserDto(User user);

    Telephone telephoneDTOtoTelephone(TelephoneDTO telephoneDTO);

    TelephoneDTO telephonetoTelephoneDTO(Telephone telephone);

    List<UserDTO> listOfUserToListOfUserDto(List<User> users);

    PersonalData personalDataDtoToPersonalData(PersonalDataDTO personalDataDTO);

    PersonalDataDTO personalDataToPersonalDataDto(PersonalData personalData);
}
