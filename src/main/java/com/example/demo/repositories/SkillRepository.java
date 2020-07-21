package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Skill;

public interface SkillRepository extends CrudRepository<Skill, Long> {

}
