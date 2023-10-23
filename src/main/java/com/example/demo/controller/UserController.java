package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.PersonalData;
import com.example.demo.model.TelephoneCode;
import com.example.demo.model.User;
import com.example.demo.model.dto.PersonalDataDTO;
import com.example.demo.model.dto.TelephoneCodeDTO;
import com.example.demo.model.dto.TelephoneDTO;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.repository.TelephoneCodeRepository;
import com.example.demo.repository.UserDataRepository;
import com.example.demo.request.InfoRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repository.UserRepository;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.uttesh.exude.exception.InvalidDataException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final UserDataRepository userDataRepository;
    private final TelephoneCodeRepository telephoneCodeRepository;
    private final UserMapper mapper;

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("user", new User());
        model.addAttribute("personal_data", userService.getPersonalDatas());
        model.addAttribute("personalData", new PersonalData());
        return "index";
    }

    @GetMapping("/info/{id}")
    public String updateInfo(@PathVariable Long id, PersonalData personalData, Model model) {
        model.addAttribute("telephone_codes", telephoneCodeRepository.findAll());
        model.addAttribute("telephone_code", new TelephoneCode());
        model.addAttribute("editUser", userDataRepository.findById(id));
        model.addAttribute("personal_data",userDataRepository.findById(id));
        return "editInfo";
    }

    @PostMapping("/info/{id}")
    public String editInfo (@ModelAttribute("personal_data") @PathVariable Long id, PersonalData personalData) {

//        Logger logger = Logger.getLogger(getClass().getName());
//        logger.info("Editing personal data with id: " + id);

        PersonalData exitingPersonalData = userRepository.findById(id).get().getPersonalData();

        exitingPersonalData.setFirstName(personalData.getFirstName());
        exitingPersonalData.setLastName(personalData.getLastName());
        exitingPersonalData.setDateOfBirth(personalData.getDateOfBirth());
        exitingPersonalData.getTelephone().setTelephoneNumber(personalData.getTelephone().getTelephoneNumber());
        exitingPersonalData.getTelephone().setTelephoneCode(personalData.getTelephone().getTelephoneCode());

        userDataRepository.save(exitingPersonalData);

        return "redirect:/users";


//        var newPersonalDataDTO =
//                PersonalDataDTO.builder()
//                        .firstName(personalData.getFirstName())
//                        .lastName(personalData.getLastName())
//                        .dateOfBirth(personalData.getDateOfBirth())
//                        .build();
//
//        User exitingUser = userRepository.findById(id).get();
//
//        exitingUser.setPersonalData(mapper.personalDataDtoToPersonalData(newPersonalDataDTO));


//         return "redirect:/info/{"+id+"}";

//        Optional<User> users = userRepository.findById(id);
//        List<PersonalData> listOfPersonalData = userRepository.findAll().stream().filter(x -> x.getId().equals(id)).flatMap(x -> Stream.of(x.getPersonalData())).collect(Collectors.toList());
//        PersonalDataDTO personalData = mapper.personalDataToPersonalDataDto(listOfPersonalData.get(0));
//        TelephoneDTO newTelephoneDTO = userService.TelephoneDTOBuilder(infoRequest);
//        PersonalDataDTO newPersonalDataDTO = userService.PersonalDataDTOBuilder(mapper.personalDataDtoToPersonalData(personalData), infoRequest, newTelephoneDTO);
//        users.get().setPersonalData(mapper.personalDataDtoToPersonalData(newPersonalDataDTO));
//        return newPersonalDataDTO;
    }


}
