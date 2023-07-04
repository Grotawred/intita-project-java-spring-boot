package com.example.demo.service;

import com.example.demo.mapper.AchievementMapper;
import com.example.demo.model.dto.CountryDTO;
import com.example.demo.model.dto.SkillDTO;
import com.example.demo.model.dto.TelephoneCodeDTO;
import com.example.demo.model.dto.ToolDTO;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.repository.TelephoneCodeRepository;
import com.example.demo.repository.ToolRepository;
import com.example.demo.service.serviceInterface.IAdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdministratorService implements IAdministratorService {

    private final CountryRepository countryRepository;

    private final TelephoneCodeRepository telephoneCodeRepository;

    private final SkillRepository skillRepository;

    private final ToolRepository toolRepository;

    private final AchievementMapper mapper;

    @Override
    public List<CountryDTO> getAllCountriesWithoutTelephoneCode() {
        return mapper.countryListToCountryDTOList(countryRepository.findAll().stream().filter(x -> x.getTelephoneCode() == null).collect(Collectors.toList()));
    }

    @Override
    public List<CountryDTO> getAllCountries() {
        return mapper.countryListToCountryDTOList(countryRepository.findAll());
    }

    @Override
    public List<ToolDTO> getAllTools() {
        return mapper.toolListToToolDTOList(toolRepository.findAll());
    }

    @Override
    public List<SkillDTO> getAllSkills() {
        return mapper.skillListToSkillDTOList(skillRepository.findAll());
    }

    @Override
    public List<TelephoneCodeDTO> getAllTelephoneCodes() {
        return mapper.telephoneCodeListToTelephoneCodeDTOList(telephoneCodeRepository.findAll());
    }

    @Override
    public void setNewCountry(CountryDTO countryDTO) {
        countryRepository.save(mapper.countryDTOToCountry(countryDTO));
    }

    @Override
    public void setNewTelephoneCode(TelephoneCodeDTO telephoneCodeDTO) {
        telephoneCodeRepository.save(mapper.telephoneCodeDTOToTelephone(telephoneCodeDTO));
    }

    @Override
    public void setNewSkill(SkillDTO skillDTO) {
        skillRepository.save(mapper.skillDTOToSkill(skillDTO));
    }

    @Override
    public void setNewTool(ToolDTO toolDTO) {
        toolRepository.save(mapper.toolDTOToTool(toolDTO));
    }

    @Override
    public void deleteCountry(CountryDTO countryDTO) {
        countryRepository.delete(mapper.countryDTOToCountry(countryDTO));
    }

    @Override
    public void deleteTelephoneCode(TelephoneCodeDTO telephoneCodeDTO) {
        telephoneCodeRepository.delete(mapper.telephoneCodeDTOToTelephone(telephoneCodeDTO));
    }

    @Override
    public void deleteSkill(SkillDTO skillDTO) {
        skillRepository.delete(mapper.skillDTOToSkill(skillDTO));
    }

    @Override
    public void deleteTool(ToolDTO toolDTO) {
        toolRepository.delete(mapper.toolDTOToTool(toolDTO));
    }
}
