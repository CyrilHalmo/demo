package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Skill extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "technology_id", nullable = false)
	private Technology technology = new Technology();

	@ManyToOne
	@JoinColumn(name = "confidence_level_id", nullable = false)
	private ConfidenceLevel confidenceLevel = new ConfidenceLevel();

	@ManyToOne
	@JoinColumn(name = "applicant_id", nullable = false)
	private Applicant applicant;

	@Column
	private String furtherInformation;

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	public ConfidenceLevel getConfidenceLevel() {
		return confidenceLevel;
	}

	public void setConfidenceLevel(ConfidenceLevel confidenceLevel) {
		this.confidenceLevel = confidenceLevel;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public String getFurtherInformation() {
		return furtherInformation;
	}

	public void setFurtherInformation(String furtherInformation) {
		this.furtherInformation = furtherInformation;
	}

}
