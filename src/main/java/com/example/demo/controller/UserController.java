package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.PersonalData;
import com.example.demo.model.User;
import com.example.demo.model.dto.PersonalDataDTO;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.registration.InfoRequest;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final UserMapper mapper;

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("editInfo/{id}")
    public PersonalDataDTO editInfo (
            @RequestBody InfoRequest infoRequest, @PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        PersonalData personalData = user.get().getPersonalData();

        personalData.setFirstName(  infoRequest.firstname() .isEmpty()? personalData.getFirstName() : infoRequest.firstname()  );
        personalData.setLastName(  infoRequest.lastname().isEmpty()? personalData.getLastName() : infoRequest.lastname() );
        personalData.setDateOfBirth(  infoRequest.dateOfBirth() == null? personalData.getDateOfBirth(): infoRequest.dateOfBirth()  );
        personalData.setProfileImageUrl(  infoRequest.profileImageUrl().isEmpty()? personalData.getProfileImageUrl() : infoRequest.profileImageUrl()  );

//        var newPersonalData =
//                PersonalData.builder()
//                        .dateOfBirth( infoRequest.dateOfBirth() == null? personalData.getDateOfBirth(): infoRequest.dateOfBirth() )
//                        .firstName( infoRequest.firstname() .isEmpty()? personalData.getFirstName() : infoRequest.firstname() )
//                        .lastName( infoRequest.lastname().isEmpty()? personalData.getLastName() : infoRequest.lastname() )
//                        .profileImageUrl( infoRequest.profileImageUrl().isEmpty()? personalData.getProfileImageUrl() : infoRequest.profileImageUrl() )
//                        .email(personalData.getEmail())
//                        .id(personalData.getId())
//                        .telephone(personalData.getTelephone())
//                        .post(personalData.getPost())
//                        .paragraphs(personalData.getParagraphs())
//                        .build();
//
//        user.get().setPersonalData(newPersonalData);

        return mapper.personalDataToPersonalDataDto(personalData);
    }

}
