package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ConfidenceLevel extends BaseEntity {

	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private Short level = 0;

	public String getName() {
		return name;
	}

	public short getLevel() {
		return level;
	}

}
