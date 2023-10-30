package com.example.demo.controller;

import com.example.demo.model.PersonalData;
import com.example.demo.model.TelephoneCode;
import com.example.demo.model.User;

import com.example.demo.repository.TelephoneCodeRepository;
import com.example.demo.repository.UserDataRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.UserRepository;

import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final UserDataRepository userDataRepository;
    private final TelephoneCodeRepository telephoneCodeRepository;

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
        model.addAttribute("user", userRepository.findById(id));
        model.addAttribute("personal_data",userDataRepository.findById(id));
        model.addAttribute("telephone_codes", telephoneCodeRepository.findAll());
        model.addAttribute("telephone_code", new TelephoneCode());
        return "editInfo";
    }

    @PostMapping("/info/{id}")
    public String editInfo (@ModelAttribute("personalData") PersonalData personalData, @PathVariable Long id) {

        PersonalData exitingPersonalData = userRepository.findById(id).get().getPersonalData();
        userService.savePersonalData(exitingPersonalData, personalData);

        return "redirect:/users";
    }


}
