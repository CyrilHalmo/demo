package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Technology;

public interface TechnologyRepository extends CrudRepository<Technology, Long> {

}
