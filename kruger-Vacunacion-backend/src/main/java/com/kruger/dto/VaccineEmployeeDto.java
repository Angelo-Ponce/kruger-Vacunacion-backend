package com.kruger.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class VaccineEmployeeDto {
	
	private Integer idVaccineEmployee;
	
	@JsonIgnore
	private EmployeeDto employee;
	
	@NotNull
	private VaccineTypeDto vaccineType;
	
	@NotNull(message = "{vaccineDate.required}")
	@NotEmpty(message = "{vaccineDate.empty}")
	private LocalDateTime vaccineDate;
	
	@NotNull(message = "{doseNumbers.required}")
	@NotEmpty(message = "{doseNumbers.empty}")
	private Integer doseNumbers;

	public Integer getIdVaccineEmployee() {
		return idVaccineEmployee;
	}

	public void setIdVaccineEmployee(Integer idVaccineEmployee) {
		this.idVaccineEmployee = idVaccineEmployee;
	}

	public EmployeeDto getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDto employee) {
		this.employee = employee;
	}

	public VaccineTypeDto getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(VaccineTypeDto vaccineType) {
		this.vaccineType = vaccineType;
	}

	public LocalDateTime getVaccineDate() {
		return vaccineDate;
	}

	public void setVaccineDate(LocalDateTime vaccineDate) {
		this.vaccineDate = vaccineDate;
	}

	public Integer getDoseNumbers() {
		return doseNumbers;
	}

	public void setDoseNumbers(Integer doseNumbers) {
		this.doseNumbers = doseNumbers;
	}
	
}
