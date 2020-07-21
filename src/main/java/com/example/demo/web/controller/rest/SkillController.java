package com.example.demo.web.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Skill;
import com.example.demo.entities.dto.DtoUtils;
import com.example.demo.entities.dto.SkillDto;
import com.example.demo.repositories.SkillRepository;

@RestController
@RequestMapping("/skills")
public class SkillController {

	@Autowired
	private SkillRepository skillRepository;
	@Autowired
	private DtoUtils dtoUtils;

	@PostMapping
	public ModelAndView add(SkillDto skillDto) {
		skillRepository.save(dtoUtils.toEntity(skillDto));
		return new ModelAndView(String.format("redirect:/skill/%s", skillDto.getApplicantId()));
	}

	@PostMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable Long id) {
		Skill skill = skillRepository.findById(id).get();
		skillRepository.delete(skill);
		return new ModelAndView(String.format("redirect:/skill/%s", skill.getApplicant().getIdentifier()));
	}

}
