package com.example.demo.entities.dto;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Applicant;
import com.example.demo.entities.ConfidenceLevel;
import com.example.demo.entities.Skill;
import com.example.demo.entities.Technology;
import com.example.demo.repositories.ApplicantRepository;
import com.example.demo.repositories.ConfidenceLevelRepository;
import com.example.demo.repositories.TechnologyRepository;

@Component
public class DtoUtils {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ApplicantRepository applicantRepository;
	@Autowired
	private ConfidenceLevelRepository confidenceLevelRepository;
	@Autowired
	private TechnologyRepository technologyRepository;

	public ApplicantDto toDto(Applicant applicant) {
		ApplicantDto applicantDto = modelMapper.map(applicant, ApplicantDto.class);
		applicantDto.setId(applicant.getIdentifier());
		applicantDto.setFirstName(applicant.getFirstName());
		applicantDto.setLastName(applicant.getLastName());
		applicantDto.setDateOfBirth(applicant.getDateOfBirth());
		applicantDto.setPhoneNumber(applicant.getPhoneNumber());
		applicantDto.setEmailAddress(applicant.getEmailAddress());
		applicantDto.setStreetName(applicant.getStreetName());
		applicantDto.setHouseNumber(applicant.getHouseNumber());
		applicantDto.setCityName(applicant.getCityName());
		applicantDto.setZipCode(applicant.getZipCode());
		applicantDto.setSkills(applicant.getSkills().stream().map(this::toDto).collect(Collectors.toSet()));
		return applicantDto;
	}

	public SkillDto toDto(Skill skill) {
		SkillDto skillDto = modelMapper.map(skill, SkillDto.class);
		skillDto.setId(skill.getIdentifier());
		skillDto.setApplicantId(skill.getApplicant().getIdentifier());
		skillDto.setConfidenceLevelId(skill.getConfidenceLevel().getIdentifier());
		skillDto.setFurtherInformation(skill.getFurtherInformation());
		skillDto.setTechnologyId(skill.getTechnology().getIdentifier());
		return skillDto;
	}

	public ConfidenceLevelDto toDto(ConfidenceLevel confidenceLevel) {
		ConfidenceLevelDto confidenceLevelDto = modelMapper.map(confidenceLevel, ConfidenceLevelDto.class);
		confidenceLevelDto.setId(confidenceLevel.getIdentifier());
		confidenceLevelDto.setLevel(confidenceLevel.getLevel());
		confidenceLevelDto.setName(confidenceLevel.getName());
		return confidenceLevelDto;
	}

	public TechnologyDto toDto(Technology technology) {
		TechnologyDto technologyDto = modelMapper.map(technology, TechnologyDto.class);
		technologyDto.setId(technology.getIdentifier());
		technologyDto.setName(technology.getName());
		return technologyDto;
	}

	public Skill toEntity(SkillDto skillDto) {
		Skill skill = modelMapper.map(skillDto, Skill.class);
		skill.setIdentifier(skillDto.getId());
		skill.setApplicant(applicantRepository.findById(skillDto.getApplicantId()).get());
		skill.setConfidenceLevel(confidenceLevelRepository.findById(skillDto.getConfidenceLevelId()).get());
		skill.setFurtherInformation(skillDto.getFurtherInformation());
		skill.setTechnology(technologyRepository.findById(skillDto.getTechnologyId()).get());
		return skill;
	}

	public Technology toEntity(TechnologyDto technologyDto) {
		Technology technology = modelMapper.map(technologyDto, Technology.class);
		technology.setName(technologyDto.getName());
		return technology;
	}

	public Applicant toEntity(ApplicantDto applicantDto) {
		Applicant applicant = modelMapper.map(applicantDto, Applicant.class);
		applicant.setIdentifier(applicantDto.getId());
		applicant.setFirstName(applicantDto.getFirstName());
		applicant.setLastName(applicantDto.getLastName());
		applicant.setDateOfBirth(applicantDto.getDateOfBirth());
		applicant.setPhoneNumber(applicantDto.getPhoneNumber());
		applicant.setEmailAddress(applicantDto.getEmailAddress());
		applicant.setStreetName(applicantDto.getStreetName());
		applicant.setHouseNumber(applicantDto.getHouseNumber());
		applicant.setCityName(applicantDto.getCityName());
		applicant.setZipCode(applicantDto.getZipCode());
		return applicant;
	}

}
