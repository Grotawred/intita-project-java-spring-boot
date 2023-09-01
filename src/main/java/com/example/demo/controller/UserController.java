package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.PersonalData;
import com.example.demo.model.User;
import com.example.demo.model.dto.PersonalDataDTO;
import com.example.demo.model.dto.TelephoneDTO;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.request.InfoRequest;
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

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final UserMapper mapper;

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("user", new User());
        return "index";
    }

    @PutMapping("/info/{id}")
    public PersonalDataDTO editInfo (
            @RequestBody @NotNull InfoRequest infoRequest, @PathVariable Long id) throws InvalidDataException, IOException {

        Optional<User> users = userRepository.findById(id);
        List<PersonalData> listOfPersonalData = userRepository.findAll().stream().filter(x -> x.getId().equals(id)).flatMap(x -> Stream.of(x.getPersonalData())).collect(Collectors.toList());
        PersonalDataDTO personalData = mapper.personalDataToPersonalDataDto(listOfPersonalData.get(0));
        TelephoneDTO newTelephoneDTO = userService.TelephoneDTOBuilder(infoRequest);
        PersonalDataDTO newPersonalDataDTO = userService.PersonalDataDTOBuilder(mapper.personalDataDtoToPersonalData(personalData), infoRequest, newTelephoneDTO);
        users.get().setPersonalData(mapper.personalDataDtoToPersonalData(newPersonalDataDTO));

        return newPersonalDataDTO;
    }


}
