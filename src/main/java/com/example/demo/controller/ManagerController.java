package com.example.demo.controller;

import com.example.demo.entity.dto.CountryDTO;
import com.example.demo.entity.dto.SkillDTO;
import com.example.demo.entity.dto.TelephoneCodeDTO;
import com.example.demo.entity.dto.ToolDTO;
import com.example.demo.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/manager")
public class ManagerController {

    private final ManagerService administratorService;


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

    @GetMapping("/telephone/codes")
    private List<TelephoneCodeDTO> getAllTelephoneCodes() {
        return administratorService.getAllTelephoneCodes();
    }

    @PostMapping("/tools")
    private void createNewTool(ToolDTO toolDTO) {
        administratorService.setNewTool(toolDTO);
    }

    @PostMapping("/skills")
    private void createNewSkill(SkillDTO skillDTO) {
        administratorService.setNewSkill(skillDTO);
    }

    @PostMapping("/countries")
    private void createNewCountry(CountryDTO countryDTO) {
        administratorService.setNewCountry(countryDTO);
    }

    @PostMapping("/telephone/codes")
    private void createNewTool(TelephoneCodeDTO telephoneCodeDTO) {
        administratorService.setNewTelephoneCode(telephoneCodeDTO);
    }

    @DeleteMapping("/tools")
    private void deleteTool(ToolDTO toolDTO) {
        administratorService.deleteTool(toolDTO);
    }

    @DeleteMapping("/skills")
    private void deleteSkill(SkillDTO skillDTO) {
        administratorService.deleteSkill(skillDTO);
    }

    @DeleteMapping("/countries")
    private void deleteCountry(CountryDTO countryDTO) {
        administratorService.deleteCountry(countryDTO);
    }

    @DeleteMapping("/telephone/codes")
    private void deleteTelephoneCode(TelephoneCodeDTO telephoneCodeDTO) {
        administratorService.deleteTelephoneCode(telephoneCodeDTO);
    }


}
