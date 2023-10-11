package com.example.demo.mapper;

import com.example.demo.entity.Country;
import com.example.demo.entity.Skill;
import com.example.demo.entity.TelephoneCode;
import com.example.demo.entity.Tool;
import com.example.demo.entity.dto.CountryDTO;
import com.example.demo.entity.dto.SkillDTO;
import com.example.demo.entity.dto.TelephoneCodeDTO;
import com.example.demo.entity.dto.ToolDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AchievementMapper {

    List<ToolDTO> toolListToToolDTOList(List<Tool> tool);

    List<Tool> toolDTOListToToolList(List<ToolDTO> toolDTO);

    List<SkillDTO> skillListToSkillDTOList(List<Skill> skill);

    List<TelephoneCodeDTO> telephoneCodeListToTelephoneCodeDTOList(List<TelephoneCode> telephoneCode);

    List<TelephoneCode> telephoneCodeDTOListToTelephoneList(List<TelephoneCodeDTO> telephoneCodeDTO);

    List<Country> countryDTOListToCountryList(List<CountryDTO> countryDTO);

    List<CountryDTO> countryListToCountryDTOList(List<Country> countries);

    ToolDTO toolToToolDTO(Tool tool);

    Tool toolDTOToTool(ToolDTO toolDTO);

    SkillDTO skillToSkillDTO(Skill skill);

    Skill skillDTOToSkill(SkillDTO skill);

    TelephoneCodeDTO telephoneCodeToTelephoneCodeDTO(TelephoneCode telephoneCode);

    TelephoneCode telephoneCodeDTOToTelephone(TelephoneCodeDTO telephoneCodeDTO);

    Country countryDTOToCountry(CountryDTO countryDTO);

    CountryDTO countryToCountryDTO(Country country);
}
