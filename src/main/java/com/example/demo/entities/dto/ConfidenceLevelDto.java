package com.example.demo.entities.dto;

public class ConfidenceLevelDto extends BaseDto implements Comparable<ConfidenceLevelDto> {

	private String name;
	private Short level;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getLevel() {
		return level;
	}

	public void setLevel(Short level) {
		this.level = level;
	}

	@Override
	public int compareTo(ConfidenceLevelDto o) {
		return o.level.compareTo(level);
	}

}
