package com.example.demo.web.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Applicant;
import com.example.demo.entities.dto.ApplicantDto;
import com.example.demo.entities.dto.DtoUtils;
import com.example.demo.repositories.ApplicantRepository;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {

	@Autowired
	private ApplicantRepository repository;
	@Autowired
	private DtoUtils dtoUtils;

	@GetMapping
	public Iterable<Applicant> defaultAction() {
		return repository.findAll();
	}

	@PostMapping
	public ModelAndView add(ApplicantDto applicantDto) {
		Applicant applicant = dtoUtils.toEntity(applicantDto);
		applicant = repository.save(applicant);
		return new ModelAndView(String.format("redirect:/skill/%s", applicant.getIdentifier()));
	}

	@PostMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable Long id) {
		Applicant applicant = repository.findById(id).get();
		repository.delete(applicant);
		return new ModelAndView(String.format("redirect:/edit"));
	}

}
