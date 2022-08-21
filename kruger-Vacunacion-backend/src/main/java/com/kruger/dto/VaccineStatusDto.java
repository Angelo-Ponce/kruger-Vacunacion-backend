package com.kruger.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class VaccineStatusDto {
	
	private Integer idVaccineStatus;
	
	@NotEmpty(message="{description.empty}")
	@Size(min = 2, message = "{description.size}")
	private String description;

	public Integer getIdVaccineStatus() {
		return idVaccineStatus;
	}

	public void setIdVaccineStatus(Integer idVaccineStatus) {
		this.idVaccineStatus = idVaccineStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
