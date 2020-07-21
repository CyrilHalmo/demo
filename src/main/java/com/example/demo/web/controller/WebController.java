package com.example.demo.web.controller;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entities.Applicant;
import com.example.demo.entities.Skill;
import com.example.demo.entities.Technology;
import com.example.demo.entities.dto.ApplicantDto;
import com.example.demo.entities.dto.DtoUtils;
import com.example.demo.entities.dto.SkillDto;
import com.example.demo.repositories.ApplicantRepository;
import com.example.demo.repositories.ConfidenceLevelRepository;
import com.example.demo.repositories.SkillRepository;
import com.example.demo.repositories.TechnologyRepository;

@Controller
public class WebController {

	@Autowired
	private ApplicantRepository applicantRepository;
	@Autowired
	private TechnologyRepository technologyRepository;
	@Autowired
	private SkillRepository skillRepository;
	@Autowired
	private ConfidenceLevelRepository confidenceLevelRepository;
	@Autowired
	private DtoUtils dtoUtils;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("applicants", StreamSupport.stream(applicantRepository.findAll().spliterator(), false)
				.map(dtoUtils::toDto).collect(Collectors.toList()));
		model.addAttribute("byName", Comparator.comparing(ApplicantDto::getLastName));
		model.addAttribute("byConfidenceLevel",
				Comparator.comparing(SkillDto::getConfidenceLevel).thenComparing(SkillDto::getTechnology));
		return "index";
	}

	@GetMapping("/applicant")
	public String add(Model model) {
		model.addAttribute("applicant", dtoUtils.toDto(new Applicant()));
		return "applicant";
	}

	@GetMapping("/skill/{id}")
	public String skill(@PathVariable Long id, Model model) {
		Skill newSkill = new Skill();
		Technology newTechnology = new Technology();
		Applicant applicant = applicantRepository.findById(id).get();
		newSkill.setApplicant(applicant);
		model.addAttribute("newSkill", dtoUtils.toDto(newSkill));
		model.addAttribute("newTechnology", dtoUtils.toDto(newTechnology));
		model.addAttribute("applicant", dtoUtils.toDto(applicant));
		model.addAttribute("technologies", StreamSupport.stream(technologyRepository.findAll().spliterator(), false)
				.map(dtoUtils::toDto).collect(Collectors.toList()));
		model.addAttribute("confidenceLevels",
				StreamSupport.stream(confidenceLevelRepository.findAll().spliterator(), false).map(dtoUtils::toDto)
						.collect(Collectors.toList()));
		model.addAttribute("byConfidenceLevel",
				Comparator.comparing(SkillDto::getConfidenceLevel).thenComparing(SkillDto::getTechnology));
		return "skills";
	}

	@GetMapping("/edit")
	public String edit(Model model) {
		model.addAttribute("byName", Comparator.comparing(ApplicantDto::getLastName));
		model.addAttribute("byConfidenceLevel",
				Comparator.comparing(SkillDto::getConfidenceLevel).thenComparing(SkillDto::getTechnology));
		model.addAttribute("applicants", StreamSupport.stream(applicantRepository.findAll().spliterator(), false)
				.map(dtoUtils::toDto).collect(Collectors.toList()));
		return "applicants";
	}

	@GetMapping("/applicant/{id}")
	public String applicant(@PathVariable Long id, Model model) {
		model.addAttribute("technologies", technologyRepository.findAll());
		model.addAttribute("confidenceLevels", confidenceLevelRepository.findAll());
		model.addAttribute("applicant", dtoUtils.toDto(applicantRepository.findById(id).get()));
		return "applicant";
	}

	@GetMapping("/skill/edit/{id}")
	public String skillEdit(@PathVariable Long id, Model model) {
		Technology newTechnology = new Technology();
		model.addAttribute("newTechnology", dtoUtils.toDto(newTechnology));
		model.addAttribute("skill", dtoUtils.toDto(skillRepository.findById(id).get()));
		model.addAttribute("technologies", StreamSupport.stream(technologyRepository.findAll().spliterator(), false)
				.map(dtoUtils::toDto).collect(Collectors.toList()));
		model.addAttribute("confidenceLevels",
				StreamSupport.stream(confidenceLevelRepository.findAll().spliterator(), false).map(dtoUtils::toDto)
						.collect(Collectors.toList()));
		return "skill";
	}

}
