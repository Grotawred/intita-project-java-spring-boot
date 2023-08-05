package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.model.dto.PersonalDataDTO;
import com.example.demo.model.dto.TelephoneDTO;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.registration.InfoRequest;
import com.example.demo.repository.TelephoneCodeRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.uttesh.exude.exception.InvalidDataException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.WordUtils;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final TelephoneCodeRepository telephoneCodeRepository;

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("editInfo/{id}")
    public PersonalDataDTO editInfo (
            @RequestBody InfoRequest infoRequest, @PathVariable Long id) throws InvalidDataException, IOException, ParseException {
        Optional<User> user = userRepository.findById(id);
        PersonalDataDTO personalData = mapper.personalDataToPersonalDataDto(user.get().getPersonalData());

       var newTelephoneDTO =
               TelephoneDTO.builder()
                               .telephoneCode(telephoneCodeRepository.findByCode(infoRequest.telephoneCode() == null? "" : infoRequest.telephoneCode()))
                               .telephoneNumber(infoRequest.telephoneNumber() == null? null : infoRequest.telephoneNumber())
                                .build();


        var newPersonalDataDTO =
                PersonalDataDTO.builder()
                        .dateOfBirth( userService.validateDateOfBirth( userService.validateLocalDate(infoRequest.dateOfBirth(), personalData.getDateOfBirth())))
                        .firstName( userService.validateSwearWords(WordUtils.capitalizeFully( userService.validateSpecialSymbols( userService.validateInfo(infoRequest.firstname(), personalData.getFirstName()) ) ) ) )
                        .lastName( userService.validateSwearWords( WordUtils.capitalizeFully( userService.validateSpecialSymbols( userService.validateInfo(infoRequest.lastname(), personalData.getLastName()) ) ) ) )
                        .profileImageUrl( userService.validateInfo(infoRequest.profileImageUrl(), personalData.getProfileImageUrl()) )
                        .email(personalData.getEmail())
                        .id(personalData.getId())
                        .telephone(mapper.telephoneDTOtoTelephone(newTelephoneDTO))
                        .post(personalData.getPost())
                        .paragraphs(personalData.getParagraphs())
                        .build();

       user.get().setPersonalData(mapper.personalDataDtoToPersonalData(newPersonalDataDTO));

        return newPersonalDataDTO;
    }


}
