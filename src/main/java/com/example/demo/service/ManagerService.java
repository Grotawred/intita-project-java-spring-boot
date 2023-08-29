package com.example.demo.service;

import com.example.demo.mapper.AchievementMapper;
import com.example.demo.entity.dto.CountryDTO;
import com.example.demo.entity.dto.SkillDTO;
import com.example.demo.entity.dto.TelephoneCodeDTO;
import com.example.demo.entity.dto.ToolDTO;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.repository.TelephoneCodeRepository;
import com.example.demo.repository.ToolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final CountryRepository countryRepository;

    private final TelephoneCodeRepository telephoneCodeRepository;

    private final SkillRepository skillRepository;

    private final ToolRepository toolRepository;

    private final AchievementMapper mapper;


    public List<CountryDTO> getAllCountriesWithoutTelephoneCode() {
        return mapper.countryListToCountryDTOList(countryRepository.findAll().stream().filter(x -> x.getTelephoneCode() == null).collect(Collectors.toList()));
    }


    public List<CountryDTO> getAllCountries() {
        return mapper.countryListToCountryDTOList(countryRepository.findAll());
    }


    public List<ToolDTO> getAllTools() {
        return mapper.toolListToToolDTOList(toolRepository.findAll());
    }


    public List<SkillDTO> getAllSkills() {
        return mapper.skillListToSkillDTOList(skillRepository.findAll());
    }


    public List<TelephoneCodeDTO> getAllTelephoneCodes() {
        return mapper.telephoneCodeListToTelephoneCodeDTOList(telephoneCodeRepository.findAll());
    }


    public void setNewCountry(CountryDTO countryDTO) {
        countryRepository.save(mapper.countryDTOToCountry(countryDTO));
    }


    public void setNewTelephoneCode(TelephoneCodeDTO telephoneCodeDTO) {
        telephoneCodeRepository.save(mapper.telephoneCodeDTOToTelephone(telephoneCodeDTO));
    }


    public void setNewSkill(SkillDTO skillDTO) {
        skillRepository.save(mapper.skillDTOToSkill(skillDTO));
    }


    public void setNewTool(ToolDTO toolDTO) {
        toolRepository.save(mapper.toolDTOToTool(toolDTO));
    }


    public void deleteCountry(CountryDTO countryDTO) {
        countryRepository.delete(mapper.countryDTOToCountry(countryDTO));
    }


    public void deleteTelephoneCode(TelephoneCodeDTO telephoneCodeDTO) {
        telephoneCodeRepository.delete(mapper.telephoneCodeDTOToTelephone(telephoneCodeDTO));
    }


    public void deleteSkill(SkillDTO skillDTO) {
        skillRepository.delete(mapper.skillDTOToSkill(skillDTO));
    }


    public void deleteTool(ToolDTO toolDTO) {
        toolRepository.delete(mapper.toolDTOToTool(toolDTO));
    }
}
