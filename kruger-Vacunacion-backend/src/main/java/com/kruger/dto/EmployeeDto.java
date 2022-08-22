package com.kruger.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

public class EmployeeDto {

	private Integer idEmployee;
	
	@Schema(description = "Dni Employee")
	@NotEmpty(message="{dni.empty}")
	@Size(min = 10, message = "{cedula.size}")
	@Pattern(regexp = "[0-9]+", message="{dni.content}")
	private String dni;
	
	@Schema(description = "Name Employee")
	@NotNull(message = "{name.required}")
	@NotEmpty(message="{name.empty}")
	@Size(min = 2, message = "{name.size}")
	@Pattern(regexp = "[A-Z a-z]+", message="{name.content}")
	private String name;
	
	@Schema(description = "LastName Employee")
	@NotNull(message = "{lastname.required}")
	@NotEmpty(message="{lastname.empty}")
	@Size(min = 2, message = "{lastname.size}")
	@Pattern(regexp = "[A-Z a-z]+", message="{lastname.content}")
	private String lastName;
	
	@Schema(description = "Email Employee")
	@NotEmpty(message="{email.empty}")
	@Email
	private String email;
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dateOfBirth;
	
	private String address;
	
	private String phone;
	
	@Schema(description = "Vaccine status the employee")
	private VaccineStatusDto vaccineStatus;
	
	@Schema(description = "Vaccine employee")
	private List<VaccineEmployeeDto> vaccineEmployee;

	
	public Integer getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Integer idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public VaccineStatusDto getVaccineStatus() {
		return vaccineStatus;
	}

	public void setVaccineStatus(VaccineStatusDto vaccineStatus) {
		this.vaccineStatus = vaccineStatus;
	}

	public List<VaccineEmployeeDto> getVaccineEmployee() {
		return vaccineEmployee;
	}

	public void setVaccineEmployee(List<VaccineEmployeeDto> vaccineEmployee) {
		this.vaccineEmployee = vaccineEmployee;
	}
	
}
