package com.example.demo.entities.dto;

public class SkillDto extends BaseDto {

	private TechnologyDto technology;
	private Long technologyId;
	private ConfidenceLevelDto confidenceLevel;
	private Long confidenceLevelId;
	private String furtherInformation;
	private ApplicantDto applicant;
	private Long applicantId;

	public TechnologyDto getTechnology() {
		return technology;
	}

	public void setTechnology(TechnologyDto technology) {
		this.technology = technology;
	}

	public Long getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(Long technologyId) {
		this.technologyId = technologyId;
	}

	public ConfidenceLevelDto getConfidenceLevel() {
		return confidenceLevel;
	}

	public void setConfidenceLevel(ConfidenceLevelDto confidenceLevel) {
		this.confidenceLevel = confidenceLevel;
	}

	public Long getConfidenceLevelId() {
		return confidenceLevelId;
	}

	public void setConfidenceLevelId(Long confidenceLevelId) {
		this.confidenceLevelId = confidenceLevelId;
	}

	public String getFurtherInformation() {
		return furtherInformation;
	}

	public void setFurtherInformation(String furtherInformation) {
		this.furtherInformation = furtherInformation;
	}

	public ApplicantDto getApplicant() {
		return applicant;
	}

	public void setApplicant(ApplicantDto applicant) {
		this.applicant = applicant;
	}

	public Long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Long applicantId) {
		this.applicantId = applicantId;
	}

}
