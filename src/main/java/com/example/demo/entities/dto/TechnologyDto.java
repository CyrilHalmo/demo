package com.example.demo.entities.dto;

public class TechnologyDto extends BaseDto implements Comparable<TechnologyDto> {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(TechnologyDto o) {
		return name.compareTo(o.name);
	}

}
