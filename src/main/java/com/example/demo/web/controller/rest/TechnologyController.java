package com.example.demo.web.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.dto.DtoUtils;
import com.example.demo.entities.dto.TechnologyDto;
import com.example.demo.repositories.TechnologyRepository;

@RestController
@RequestMapping("/technologies")
public class TechnologyController {

	@Autowired
	private TechnologyRepository technologyRepository;
	@Autowired
	private DtoUtils dtoUtils;

	@PostMapping("/{id}")
	public ModelAndView add(@PathVariable Long id, TechnologyDto technologyDto) {
		technologyRepository.save(dtoUtils.toEntity(technologyDto));
		return new ModelAndView(String.format("redirect:/skill/%s", id));
	}
	
	@PostMapping("/{id}/skill")
	public ModelAndView addFromSkill(@PathVariable Long id, TechnologyDto technologyDto) {
		technologyRepository.save(dtoUtils.toEntity(technologyDto));
		return new ModelAndView(String.format("redirect:/skill/edit/%s", id));
	}

}
