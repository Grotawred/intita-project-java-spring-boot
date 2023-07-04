package com.example.demo.controller;

import com.example.demo.model.dto.CountryDTO;
import com.example.demo.model.dto.SkillDTO;
import com.example.demo.model.dto.TelephoneCodeDTO;
import com.example.demo.model.dto.ToolDTO;
import com.example.demo.service.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdministratorController {

    private final AdministratorService administratorService;


    @GetMapping("/tools")
    private List<ToolDTO> getAllTools() {
        return administratorService.getAllTools();
    }

    @GetMapping("/skills")
    private List<SkillDTO> getAllSkills() {
        return administratorService.getAllSkills();
    }

    @GetMapping("/countries")
    private List<CountryDTO> getAllCountries() {
        return administratorService.getAllCountries();
    }

    @GetMapping("/telephoneCodes")
    private List<TelephoneCodeDTO> getAllTelephoneCodes() {
        return administratorService.getAllTelephoneCodes();
    }

    @PostMapping("/tool/create")
    private void createNewTool(ToolDTO toolDTO) {
        administratorService.setNewTool(toolDTO);
    }

    @PostMapping("/skill/create")
    private void createNewSkill(SkillDTO skillDTO) {
        administratorService.setNewSkill(skillDTO);
    }

    @PostMapping("/country/create")
    private void createNewCountry(CountryDTO countryDTO) {
        administratorService.setNewCountry(countryDTO);
    }

    @PostMapping("/telephoneCode/create")
    private void createNewTool(TelephoneCodeDTO telephoneCodeDTO) {
        administratorService.setNewTelephoneCode(telephoneCodeDTO);
    }

    @GetMapping("/tool/delete")
    private void deleteTool(ToolDTO toolDTO) {
        administratorService.deleteTool(toolDTO);
    }

    @GetMapping("/skill/delete")
    private void deleteSkill(SkillDTO skillDTO) {
        administratorService.deleteSkill(skillDTO);
    }

    @GetMapping("/country/delete")
    private void deleteCountry(CountryDTO countryDTO) {
        administratorService.deleteCountry(countryDTO);
    }

    @GetMapping("/telephoneCode/delete")
    private void deleteTelephoneCode(TelephoneCodeDTO telephoneCodeDTO) {
        administratorService.deleteTelephoneCode(telephoneCodeDTO);
    }


}
