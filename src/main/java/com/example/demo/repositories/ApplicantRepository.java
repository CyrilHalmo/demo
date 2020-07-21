package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Applicant;

public interface ApplicantRepository extends CrudRepository<Applicant, Long> {

}
