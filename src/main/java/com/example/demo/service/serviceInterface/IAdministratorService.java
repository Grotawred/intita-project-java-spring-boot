package com.example.demo.service.serviceInterface;

import com.example.demo.model.dto.CountryDTO;
import com.example.demo.model.dto.SkillDTO;
import com.example.demo.model.dto.TelephoneCodeDTO;
import com.example.demo.model.dto.ToolDTO;

import java.util.List;

public interface IAdministratorService {

    List<CountryDTO> getAllCountriesWithoutTelephoneCode();

    List<CountryDTO> getAllCountries();

    List<ToolDTO> getAllTools();

    List<SkillDTO> getAllSkills();

    List<TelephoneCodeDTO> getAllTelephoneCodes();

    void setNewCountry(CountryDTO country);

    void setNewTelephoneCode(TelephoneCodeDTO telephoneCode);

    void setNewSkill(SkillDTO skill);

    void setNewTool(ToolDTO tool);

    void deleteCountry(CountryDTO country);

    void deleteTelephoneCode(TelephoneCodeDTO telephoneCode);

    void deleteSkill(SkillDTO skill);

    void deleteTool(ToolDTO tool);

}
