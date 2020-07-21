package com.example.demo.entities.dto;

import java.sql.Date;
import java.util.Set;

public class ApplicantDto extends BaseDto {

	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String phoneNumber;
	private String emailAddress;
	private Set<SkillDto> skills;
	private Set<Long> skillIds;
	private String streetName;
	private Integer houseNumber;
	private String cityName;
	private Integer zipCode;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Set<SkillDto> getSkills() {
		return skills;
	}

	public void setSkills(Set<SkillDto> skills) {
		this.skills = skills;
	}

	public Set<Long> getSkillIds() {
		return skillIds;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public Integer getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public void setSkillIds(Set<Long> skillIds) {
		this.skillIds = skillIds;
	}
	
}
