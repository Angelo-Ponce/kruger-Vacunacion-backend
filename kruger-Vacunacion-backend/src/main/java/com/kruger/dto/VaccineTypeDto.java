package com.kruger.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Tipo de Vacuna")
public class VaccineTypeDto {
	
	private Integer idVaccineType;
	
	@NotNull(message = "{name.required}")
	@Size(min = 1, message = "{name.size}")
	private String name;
	
	@NotNull(message = "{description.required}")
	@Size(min = 1, message = "{description.size}")
	private String description;
	

	public Integer getIdVaccineType() {
		return idVaccineType;
	}

	public void setIdVaccineType(Integer idVaccineType) {
		this.idVaccineType = idVaccineType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
